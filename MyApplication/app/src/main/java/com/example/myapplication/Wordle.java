package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Wordle extends AppCompatActivity{
    private TextView nameDisplay;
    private ImageView dynamicImageView;
    private char[] qwerty = {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P',
            'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', '*',
            'Z', 'X', 'C', 'V', 'B', 'N', 'M','*','*','*'};
    private String curr = "";
    private boolean backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.wordle);

        nameDisplay = findViewById(R.id.player1Name);
        nameDisplay.setText(InitialConfigWordle.userName);

        dynamicImageView = findViewById(R.id.player1Avatar);
        dynamicImageView.setImageDrawable(InitialConfigWordle.avatar.getDrawable());
        boardMake();
    }

    private void boardMake(){
        GridLayout keyboard = (GridLayout) findViewById(R.id.KeyBoard);
        keyboard.removeAllViews();
        backspace = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                if(10 * i + j == 19 || 10 * i + j >= 27) {
                    if (backspace) {
                        View inflated = View.inflate(Wordle.this, R.layout.key_button, keyboard);
                        View intersectionCur = (View) findViewById(R.id.button_x);
                        intersectionCur.setId(10 * i + j);

                        FrameLayout cur = (FrameLayout) intersectionCur;
                        cur.getChildAt(0).setId(10 * i + j);
                        cur.getChildAt(0).setOnClickListener(this::delete);

                        TextView key = (TextView) cur.getChildAt(1);
                        key.setText("<");
                        backspace = false;
                    } else {
                        View inflated = View.inflate(Wordle.this, R.layout.key_button, keyboard);
                        View intersectionCur = (View) findViewById(R.id.button_x);
                        intersectionCur.setId(10 * i + j);

                        FrameLayout cur = (FrameLayout) intersectionCur;
                        cur.getChildAt(0).setId(10 * i + j);
                        cur.getChildAt(0).setOnClickListener(this::submit);

                        TextView key = (TextView) cur.getChildAt(1);
                        key.setText("=");
                    }
                } else {
                    View inflated = View.inflate(Wordle.this, R.layout.key_button,keyboard);
                    View intersectionCur = (View) findViewById(R.id.button_x);
                    intersectionCur.setId(10 * i + j);

                    FrameLayout cur = (FrameLayout) intersectionCur;
                    cur.getChildAt(0).setId(10 * i + j);

                    TextView key = (TextView) cur.getChildAt(1);
                    key.setText(Character.toString(qwerty[10 * i + j]));
                }
            }
        }
    }
    //this builds the current word guess
    public void append(View key) {
        char letter = qwerty[key.getId()];
        if (curr.length() < 5) {
            //this is where you update the grid han/yaunning
            curr = curr + letter;
        }
        System.out.println(curr);
    }

    public void delete(View key) {
        if (curr.length() > 0) {
            //this is where you update the grid han/yaunning
            curr = curr.substring(0, curr.length() - 1);
        }
        System.out.println(curr);
    }

    public void submit(View key) {
        if (curr.length() == 5) {
            //this is where you call for the logic Taiki/ hussein
            System.out.println(curr);
        }
    }
}
