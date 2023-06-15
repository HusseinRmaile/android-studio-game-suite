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
    private TextView nameDisplay;
    private ImageView dynamicImageView;
    private LinearLayout goBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.gomoku);

        nameDisplay = findViewById(R.id.nameDisplay);
        nameDisplay.setText(InitialConfigGomoku.userName);

        dynamicImageView = findViewById(R.id.dynamicImageView);
        dynamicImageView.setImageDrawable(InitialConfigGomoku.avatar.getDrawable());

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
