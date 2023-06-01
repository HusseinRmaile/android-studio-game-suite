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

        nameDisplay = findViewById(R.id.nameDisplay);
        nameDisplay.setText(InitialConfigWordle.userName);

        dynamicImageView = findViewById(R.id.dynamicImageView);
        dynamicImageView.setImageDrawable(InitialConfigWordle.avatar.getDrawable());
    }
}
