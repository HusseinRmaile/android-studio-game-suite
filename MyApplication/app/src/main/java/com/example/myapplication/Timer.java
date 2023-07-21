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

    private static Timer uniqueTimer;
    private CountDownTimer shotClock;
    private Timer(){
        return;
    }


    public void time(TextView mTextField) {
        shotClock = new CountDownTimer(30000, 1000) {

            @SuppressLint("SetTextI18n")
            public void onTick(long millisUntilFinished) {
                mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            @SuppressLint("SetTextI18n")
            public void onFinish() {
                mTextField.setText("");

            }
        }.start();

    }

    public void stop() {
        shotClock.cancel();
    }


    public static Timer getInstance() {
        if (uniqueTimer == null) {
            uniqueTimer = new Timer();
        }
        return uniqueTimer;
    }

}
