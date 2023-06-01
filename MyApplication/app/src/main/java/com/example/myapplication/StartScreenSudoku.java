package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class StartScreenSudoku extends AppCompatActivity{
    private Button startGame, quitGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen_sudoku);

        startGame = findViewById(R.id.startGame);
        quitGame = findViewById(R.id.quitGame);

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartScreenSudoku.this, InitialConfigSudoku.class);
                startActivity(intent);
            }
        });

        quitGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartScreenSudoku.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
