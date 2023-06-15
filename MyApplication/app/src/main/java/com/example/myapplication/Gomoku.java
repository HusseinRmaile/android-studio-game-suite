package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Gomoku extends AppCompatActivity{

    final static int bSize = 19;
    private LinearLayout goBoard;
    private TextView player1Name;
    private ImageView player1Avatar;
    private TextView player2Name;
    private ImageView player2Avatar;
    private GomokuPlayer player1;
    private GomokuPlayer player2;
    private GomokuBoard board;
    private int row;
    private int col;
    private int piece;
    private int gameState;
    private int turn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.gomoku);

        player1Name = findViewById(R.id.player1Name);
        player1Name.setText(InitialConfigGomoku.userName1);
        player2Name = findViewById(R.id.player2Name);
        player2Name.setText(InitialConfigGomoku.userName2);

        player1Avatar = findViewById(R.id.player1Avatar);
        player1Avatar.setImageDrawable(InitialConfigGomoku.player_avatar1.getDrawable());
        player2Avatar = findViewById(R.id.player2Avatar);
        player2Avatar.setImageDrawable(InitialConfigGomoku.player_avatar2.getDrawable());

        boardMake();

        player1 = new GomokuPlayer(1);
        player2 = new GomokuPlayer(2);
        board = new GomokuBoard();
        gameState = -1;
        turn = 0;


    }
    private void boardMake(){
        GridLayout griddy = (GridLayout) findViewById(R.id.griddy);
        griddy.removeAllViews();
        for (int i = 0; i < bSize; i++) {
            for (int j = 0; j < bSize; j++) {
                View inflated = View.inflate(Gomoku.this, R.layout.intersection_button,griddy);
                View intersectionCur = (View) findViewById(R.id.empty_intersection);
                intersectionCur.setId(i * bSize + j);
            }
        }
    }
    public void place (View button) {
        System.out.println("aaaa");
        ImageButton buttonCur = (ImageButton) button;
        ImageView turnbox = (ImageView) findViewById(R.id.turnbox);
        piece = buttonCur.getId();
        row = piece / bSize;
        col = piece % bSize;
        int gamestate = board.placePiece(row, col, turn % 2 + 1);
        if (gamestate == 0) {
            // add piece, swap turns

            if(turn % 2 == 0) {
                buttonCur.setImageResource(R.drawable.black_intersection);
                turnbox.setBackgroundColor(Color.WHITE);

            } else {
                buttonCur.setImageResource(R.drawable.white_intersection);
                turnbox.setBackgroundColor(Color.BLACK);
            }
            turn++;
        } else if (gamestate == 1) {
            //player 1 win
        } else if (gamestate == 2) {
            //player 2 win
        } else {
            //board full
        }
    }
}