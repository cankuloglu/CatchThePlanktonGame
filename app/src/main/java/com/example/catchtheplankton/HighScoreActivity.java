package com.example.catchtheplankton;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class HighScoreActivity extends AppCompatActivity {
    TextView textViewHighScore1;
    TextView textViewHighScore2;
    TextView textViewHighScore3;
    SharedPreferences sharedPreferences;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
        textViewHighScore1 = findViewById(R.id.textViewHighScore1);
        textViewHighScore2 = findViewById(R.id.textViewHighScore2);
        textViewHighScore3 = findViewById(R.id.textViewHighScore3);

        sharedPreferences = getSharedPreferences("MyHighScorePreferences",MODE_PRIVATE);
        int highscore1 = sharedPreferences.getInt("highscore1", 0);
        textViewHighScore1.setText("" + highscore1);
        sharedPreferences = getSharedPreferences("MyHighScorePreferences2",MODE_PRIVATE);
        int highscore2 = sharedPreferences.getInt("highscore2", 0);
        textViewHighScore2.setText("" + highscore2);
        sharedPreferences = getSharedPreferences("MyHighScorePreferences3",MODE_PRIVATE);
        int highscore3 = sharedPreferences.getInt("highscore3", 0);
        textViewHighScore3.setText("" + highscore3);








        }



    }

