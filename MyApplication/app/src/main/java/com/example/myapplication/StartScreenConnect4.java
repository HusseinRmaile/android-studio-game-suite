package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class StartScreenConnect4 extends AppCompatActivity{
    private Button startGame, quitGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen_connect4);

        startGame = findViewById(R.id.startGame);
        quitGame = findViewById(R.id.quitGame);

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartScreenConnect4.this, InitialConfigConnect4.class);
                startActivity(intent);
            }
        });

        quitGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartScreenConnect4.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
