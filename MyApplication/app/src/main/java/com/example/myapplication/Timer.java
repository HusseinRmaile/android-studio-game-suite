package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;

import java.text.BreakIterator;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Timer {
    private static final long timeLimit = 5 * 60000;
    private static final long interval = 1000;
    private CountDownTimer timer;


    public void time(TextView mTextField) {
        new CountDownTimer(30000, 1000) {

            @SuppressLint("SetTextI18n")
            public void onTick(long millisUntilFinished) {
                mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            @SuppressLint("SetTextI18n")
            public void onFinish() {
                mTextField.setText("done!");
            }
        }.start();

    }

    public void stop() {}

}
