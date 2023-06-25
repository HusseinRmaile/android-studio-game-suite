package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EndConnect4 extends AppCompatActivity{
    private TextView player1Name;
    private ImageView player1Avatar;
    private TextView player2Name;
    private ImageView player2Avatar;

    private Button playAgain, quitGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_connect4);

        TextView winMessage = findViewById(R.id.winMessage);
        winMessage.setText(Connect4.winMessage);

        player1Name = findViewById(R.id.player1Name);
        player1Name.setText(InitialConfigConnect4.userName1);
        player2Name = findViewById(R.id.player2Name);
        player2Name.setText(InitialConfigConnect4.userName2);

        player1Avatar = findViewById(R.id.player1Avatar);
        player1Avatar.setImageDrawable(InitialConfigConnect4.player_avatar1.getDrawable());
        player2Avatar = findViewById(R.id.player2Avatar);
        player2Avatar.setImageDrawable(InitialConfigConnect4.player_avatar2.getDrawable());

        TextView player1WinCount = findViewById(R.id.player1WinCount);
        int player1Win = getIntent().getIntExtra("player1WinCounter", 0);
        player1WinCount.setText(Integer.toString(player1Win));
        TextView player2WinCount = findViewById(R.id.player2WinCount);
        int player2Win = getIntent().getIntExtra("player2WinCounter", 0);
        player2WinCount.setText(Integer.toString(player2Win));
        TextView drawCount = findViewById(R.id.drawCount);
        int draw = getIntent().getIntExtra("drawCounter", 0);
        drawCount.setText(Integer.toString(draw));

        playAgain = findViewById(R.id.playAgain);
        quitGame = findViewById(R.id.quitGame);

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EndConnect4.this, Connect4.class);
                startActivity(intent);
            }
        });
        quitGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EndConnect4.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

