package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import java.io.*;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Gomoku extends AppCompatActivity{

    public String winMessage;
    private GomokuBoard board;
    private int row;
    private int col;
    private int piece;
    private int gameState;

    //private int drawCount = InitialConfigGomoku.drawCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        GomokuPlayer player1 = InitialConfigGomoku.player1;
        GomokuPlayer player2 = InitialConfigGomoku.player2;

        int player1WinCounter = player1.getWinCounter();
        int player2WinCounter = player2.getWinCounter();
        int drawCount = player1.getDrawCounter();
        Log.d("Gomoku", "Player 1 win count: " + player1.getWinCounter());
        Log.d("Gomoku", "Player 2 win count: " + player2.getWinCounter());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.gomoku);

        TextView player1Name = findViewById(R.id.player1Name);
        player1Name.setText(InitialConfigGomoku.userName1);
        TextView player2Name = findViewById(R.id.player2Name);
        player2Name.setText(InitialConfigGomoku.userName2);

        ImageView player1Avatar = findViewById(R.id.player1Avatar);
        player1Avatar.setImageDrawable(InitialConfigGomoku.player_avatar1.getDrawable());
        ImageView player2Avatar = findViewById(R.id.player2Avatar);
        player2Avatar.setImageDrawable(InitialConfigGomoku.player_avatar2.getDrawable());

        TextView player1WinCount = findViewById(R.id.player1WinCount);
        player1WinCount.setText(Integer.toString(player1WinCounter));
        TextView player2WinCount = findViewById(R.id.player2WinCount);
        player2WinCount.setText(Integer.toString(player2WinCounter));
        TextView draw = findViewById(R.id.drawCount);
        draw.setText(Integer.toString(drawCount));

        //can be deleted once win counter works
        Button keepGame = findViewById(R.id.button);
        Button drawButton = findViewById(R.id.button4);
        Button player1Wins = findViewById(R.id.button2);
        Button player2Wins = findViewById(R.id.button3);

        board = new GomokuBoard();
        gameState = -1;

        //gameState = board.placePiece(row, col, piece);
        keepGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {gameState = -1;}
        });
        drawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameState = 0;
                Log.d("Gomoku", "draw count: " + player1.getDrawCounter());
                player1.setDrawCounter(player1.getDrawCounter() + 1);
                player2.setDrawCounter(player2.getDrawCounter() + 1);
                winMessage = "It's a draw!";
                Log.d("Gomoku", "draw count: " + player1.getDrawCounter());
                Intent intent = new Intent(Gomoku.this, EndGomoku.class);
                intent.putExtra("player1WinCounter", player1.getWinCounter());
                intent.putExtra("player2WinCounter", player2.getWinCounter());
                intent.putExtra("drawCounter", player1.getDrawCounter());
                startActivity(intent);
            }
        });
        player1Wins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameState = 1;
                player1.setWinCounter(player1.getWinCounter() + 1);
                winMessage = "Player 1 wins!";
                Log.d("Gomoku", "Player 1 win count: " + player1.getWinCounter());
                Intent intent = new Intent(Gomoku.this, EndGomoku.class);
                intent.putExtra("player1WinCounter", player1.getWinCounter());
                intent.putExtra("player2WinCounter", player2.getWinCounter());
                intent.putExtra("drawCounter", player1.getDrawCounter());
                startActivity(intent);
            }
        });
        player2Wins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameState = 2;
                player2.setWinCounter(player2.getWinCounter() + 1);
                winMessage = "Player 2 wins!";
                Log.d("Gomoku", "Player 2 win count: " + player2.getWinCounter());
                Intent intent = new Intent(Gomoku.this, EndGomoku.class);
                intent.putExtra("player1WinCounter", player1.getWinCounter());
                intent.putExtra("player2WinCounter", player2.getWinCounter());
                intent.putExtra("drawCounter", player1.getDrawCounter());
                startActivity(intent);
            }
        });
    }
}
