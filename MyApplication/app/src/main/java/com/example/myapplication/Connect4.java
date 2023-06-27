package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.graphics.Color;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Connect4 extends AppCompatActivity{
    public static String winMessage;
    final static int numRows = 6 + 1; // 1 extra row for arrows at top, not part of board
    final static int numCols = 7;
    private LinearLayout c4Board;
    private TextView player1Name;
    private ImageView player1Avatar;
    private TextView player2Name;
    private ImageView player2Avatar;
    private Connect4Player player1;
    private Connect4Player player2;
    private Connect4Board board;
    private int row;
    private int col;
    private int piece;
    private int turn;
    private ImageButton[][] buttons;
    private int[] colHeight;
    private int gameState = -1;
    //private int drawCount = InitialConfigConnect4.drawCount;
    Connect4Player p1 = InitialConfigConnect4.player1;
    Connect4Player p2 = InitialConfigConnect4.player2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        int player1WinCounter = p1.getWinCounter();
        int player2WinCounter = p2.getWinCounter();
        int drawCount = p1.getDrawCounter();
        Log.d("Connect4", "Player 1 win count: " + p1.getWinCounter());
        Log.d("Connect4", "Player 2 win count: " + p2.getWinCounter());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.connect4);

        TextView player1Name = findViewById(R.id.player1Name);
        player1Name.setText(InitialConfigConnect4.userName1);
        TextView player2Name = findViewById(R.id.player2Name);
        player2Name.setText(InitialConfigConnect4.userName2);

        ImageView player1Avatar = findViewById(R.id.player1Avatar);
        player1Avatar.setImageDrawable(InitialConfigConnect4.player_avatar1.getDrawable());
        ImageView player2Avatar = findViewById(R.id.player2Avatar);
        player2Avatar.setImageDrawable(InitialConfigConnect4.player_avatar2.getDrawable());

        TextView player1WinCount = findViewById(R.id.player1WinCount);
        player1WinCount.setText(Integer.toString(player1WinCounter));
        TextView player2WinCount = findViewById(R.id.player2WinCount);
        player2WinCount.setText(Integer.toString(player2WinCounter));
        TextView draw = findViewById(R.id.drawCount);
        draw.setText(Integer.toString(drawCount));

        boardMake();

        board = new Connect4Board();
        turn = 0;
        Log.d("Connect4", "game state is " + gameState);


    }
    private void boardMake(){
        buttons = new ImageButton[numRows][numCols];
        GridLayout griddy = (GridLayout) findViewById(R.id.griddy);
        griddy.removeAllViews();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                View inflated = View.inflate(Connect4.this, R.layout.intersection_button,griddy);
                View intersectionCur = (View) findViewById(R.id.empty_intersection);
                intersectionCur.setId(i * numCols + j);
                ImageButton buttonCur = (ImageButton) intersectionCur;
                buttons[i][j] = buttonCur;
                Log.d("Connect4", "i="+i+"j="+j);
                Log.d("Connect4", "buttonId: " + buttons[i][j]);
                if (i == 0) {
                    if (j == 0) {
                        buttonCur.setImageResource(R.drawable.wall_topleft);
                    } else if (j == numCols - 1) {
                        buttonCur.setImageResource(R.drawable.wall_topright);
                    } else {
                        buttonCur.setImageResource(R.drawable.wall_top);
                    }
                } else if (j == 0) {
                    if (i == numRows - 1) {
                        buttonCur.setImageResource(R.drawable.wall_bottomleft);
                    } else {
                        buttonCur.setImageResource(R.drawable.wall_left);
                    }
                } else if (i == numRows - 1) {
                    if (j == numCols - 1) {
                        buttonCur.setImageResource(R.drawable.wall_bottomright);
                    } else {
                        buttonCur.setImageResource(R.drawable.wall_bottom);
                    }
                } else if (j == numCols - 1) {
                    buttonCur.setImageResource(R.drawable.wall_right);
                }
            }
        }
        colHeight = new int[numCols];
        for (int i = 0; i < numCols; i++){
            colHeight[i] = 0;
        }
    }
    public void place (View button) {
        boolean topRow = false;
        for (int j = 0; j < numCols; j++) {
            if ((ImageButton) button == buttons[0][j]) {
                topRow = true;
            }
        }
        if (!topRow){
            return;
        }
        ImageButton buttonCur = (ImageButton) button;
        ImageView turnbox = (ImageView) findViewById(R.id.turnbox);
        piece = buttonCur.getId();
        Log.d("Connect4", "buttonId: " + piece);
        row = piece / numCols;
        col = piece % numCols;
        if (colHeight[col] < (numRows - 1)){
            row = (numRows - 1) - colHeight[col];
            colHeight[col] = colHeight[col] + 1;
        } else {
            return;
        }
        gameState = board.placePiece(row, col, turn % 2 + 1);
        buttonCur = buttons[row][col];
        Log.d("Connect4", "buttonId: " + piece);

        if (gameState == 0) {
            //0 means piece was placed and game continues
            // add piece, swap turns
            if(turn % 2 == 0) {
                buttonCur.setImageResource(R.drawable.black);
                turnbox.setBackgroundColor(Color.WHITE);
            } else {
                buttonCur.setImageResource(R.drawable.white);
                turnbox.setBackgroundColor(Color.BLACK);
            }
            turn++;
        } else if (gameState == -1) {
            //-1 means piece is out of bounds or on an occupied space, was not placed
            return;
        } else if (gameState == -2) {
            //-2 means board is full and no win is present, so it's a draw
            p1.setDrawCounter(p1.getDrawCounter() + 1);
            p2.setDrawCounter(p2.getDrawCounter() + 1);
            winMessage = "It's a draw!";
            Log.d("Connect4", "draw count: " + p1.getDrawCounter());
            Intent intent = new Intent(Connect4.this, EndConnect4.class);
            intent.putExtra("player1WinCounter", p1.getWinCounter());
            intent.putExtra("player2WinCounter", p2.getWinCounter());
            intent.putExtra("drawCounter", p1.getDrawCounter());
            startActivity(intent);
        } else if (gameState == 1) {
            //player 1 win
            p1.setWinCounter(p1.getWinCounter() + 1);
            winMessage = "Player 1 wins!";
            Log.d("Connect4", "Player 1 win count: " + p1.getWinCounter());
            Intent intent = new Intent(Connect4.this, EndConnect4.class);
            intent.putExtra("player1WinCounter", p1.getWinCounter());
            intent.putExtra("player2WinCounter", p2.getWinCounter());
            intent.putExtra("drawCounter", p1.getDrawCounter());
            startActivity(intent);
        } else if (gameState == 2) {
            //player 2 win
            p2.setWinCounter(p2.getWinCounter() + 1);
            winMessage = "Player 2 wins!";
            Log.d("Connect4", "Player 2 win count: " + p2.getWinCounter());
            Intent intent = new Intent(Connect4.this, EndConnect4.class);
            intent.putExtra("player1WinCounter", p1.getWinCounter());
            intent.putExtra("player2WinCounter", p2.getWinCounter());
            intent.putExtra("drawCounter", p1.getDrawCounter());
            startActivity(intent);
        } else if (gameState == -2) {
            //something went wrong if it makes it here
            return;
        }
    }
}
