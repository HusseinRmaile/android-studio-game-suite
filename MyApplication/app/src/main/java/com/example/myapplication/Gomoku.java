package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.ImageView;
import android.widget.TextView;

public class Gomoku extends AppCompatActivity{
    private TextView player1Name;
    private ImageView player1Avatar;
    private TextView player2Name;
    private ImageView player2Avatar;

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
    }
}
