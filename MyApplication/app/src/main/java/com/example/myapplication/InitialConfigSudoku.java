package com.example.myapplication;

//import android.content.Intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InitialConfigSudoku extends AppCompatActivity{
    private EditText inputEditText;
    private Button storeButton;
    private TextView displayTextView;
    private ImageView avatar1;
    private ImageView avatar2;
    public static String userName;
    public static ImageView avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_config_sudoku);

        inputEditText = findViewById(R.id.inputName1);
        storeButton = findViewById(R.id.storeButton);
        displayTextView = findViewById(R.id.displayTextView);
        avatar1 = findViewById(R.id.avatar1);
        avatar2 = findViewById(R.id.avatar2);

        avatar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                avatar = avatar1;
            }
        });

        avatar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                avatar = avatar2;
            }
        });

        storeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = inputEditText.getText().toString();
                boolean invalid = true;
                for (int i = 0; i < userName.length(); i++){
                    if (userName.charAt(i) != ' '){
                        invalid = false;
                    }
                }
                if (invalid) {
                    inputEditText.setError("Invalid name");
                } else if (avatar == null) {
                    inputEditText.setError("Choose an avatar");
                } else {
                    Intent intent = new Intent(InitialConfigSudoku.this, Sudoku.class);
                    startActivity(intent);
                }
            }
        });
    }
}
