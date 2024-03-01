package com.example.catchtheplankton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LauncherActivity extends AppCompatActivity {
    TextView textView;
    Button playButton;
    Button highsccorebutton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        highsccorebutton = findViewById(R.id.highscorebutton);



    }






    public void startGame (View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.custom_fade_in, R.anim.custom_fade_out);

    }
    public void highscoreActivity (View view){
        Intent intent = new Intent(this,HighScoreActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.custom_fade_in, R.anim.custom_fade_out);

    }

}