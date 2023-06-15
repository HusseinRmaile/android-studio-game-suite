package com.example.myapplication;

import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Sudoku extends AppCompatActivity{
    private TextView nameDisplay;
    private ImageView dynamicImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sudoku);

        nameDisplay = findViewById(R.id.player1Name);
        nameDisplay.setText(InitialConfigSudoku.userName);

        dynamicImageView = findViewById(R.id.player1Avatar);
        dynamicImageView.setImageDrawable(InitialConfigSudoku.avatar.getDrawable());


    }
    private void buildBoard() {
        GridLayout griddy = (GridLayout) findViewById(R.id.griddy);
    }
}
