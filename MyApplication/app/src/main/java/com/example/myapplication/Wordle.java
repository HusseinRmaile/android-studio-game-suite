package com.example.myapplication;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Wordle extends AppCompatActivity{
    private TextView nameDisplay;
    private ImageView dynamicImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.wordle);

        nameDisplay = findViewById(R.id.player1Name);
        nameDisplay.setText(InitialConfigWordle.userName);

        dynamicImageView = findViewById(R.id.player1Avatar);
        dynamicImageView.setImageDrawable(InitialConfigWordle.avatar.getDrawable());
    }
}
