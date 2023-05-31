package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.ImageView;
import android.widget.TextView;

public class Gomoku extends AppCompatActivity{
    private TextView nameDisplay;
    private ImageView dynamicImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.gomoku);

        nameDisplay = findViewById(R.id.nameDisplay);
        nameDisplay.setText(InitialConfig.userName);

        dynamicImageView = findViewById(R.id.dynamicImageView);
        dynamicImageView.setImageDrawable(InitialConfig.avatar.getDrawable());
    }
}
