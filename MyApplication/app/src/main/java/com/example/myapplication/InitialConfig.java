package com.example.myapplication;

//import android.content.Intent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
public class InitialConfig extends AppCompatActivity{
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
        setContentView(R.layout.initial_config);

        inputEditText = findViewById(R.id.inputEditText);
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
                if (MainActivity.gameChosen.equals("gomoku")){
                    //displayTextView.setText("you chose the gomoku game");
                    Intent intent = new Intent(InitialConfig.this, Gomoku.class);
                    startActivity(intent);
                } else if (MainActivity.gameChosen.equals("sudoku")) {
                    //displayTextView.setText("you chose the sudoku game");
                    Intent intent = new Intent(InitialConfig.this, Gomoku.class);
                    startActivity(intent);
                } else if (MainActivity.gameChosen.equals("wordle")) {
                    //displayTextView.setText("you chose the wordle game");
                    Intent intent = new Intent(InitialConfig.this, Gomoku.class);
                    startActivity(intent);}
            }
        });
    }
}
