package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.GridLayout;
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
}