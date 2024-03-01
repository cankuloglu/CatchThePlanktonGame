package com.example.catchtheplankton;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    TextView timeText;
    TextView scoreText;
    int score;
    ImageView imageView;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;
    Button resButton;
    Button startButton;
    Button button4;

    int highscore2;
    int lastRandomIndex = -1;






    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        timeText = findViewById(R.id.timeText);
        scoreText = findViewById(R.id.scoreText);
        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);
        startButton = findViewById(R.id.startButton);
        resButton = findViewById(R.id.resButton);
        button4 = findViewById(R.id.button3);


        imageArray = new ImageView[]{imageView,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9};

        score = 0;


        imageView.setVisibility(View.GONE);
        imageView2.setVisibility(View.GONE);
        imageView3.setVisibility(View.GONE);
        imageView4.setVisibility(View.GONE);
        imageView5.setVisibility(View.GONE);
        imageView6.setVisibility(View.GONE);
        imageView7.setVisibility(View.GONE);
        imageView8.setVisibility(View.GONE);
        imageView9.setVisibility(View.GONE);
        resButton.setEnabled(false);
        button4.setEnabled(false);
        sharedPreferences = this.getSharedPreferences("MyHighScorePreferences2", Context.MODE_PRIVATE);
        highscore2 = sharedPreferences.getInt("highscore2", 0);




    }
    public void highScore2(){
        if (score > highscore2) {
            highscore2 = score;
            sharedPreferences.edit().putInt("highscore2", highscore2).apply();
        }
    }
    public void increaseScore(View view) {
        score++;
        scoreText.setText("Score: " + score);

    }
    public void hideImages(){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for(ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }
                Random random = new Random();
                int i;
                do {
                    i = random.nextInt(9);
                } while (i == lastRandomIndex);

                lastRandomIndex = i;

                imageArray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(runnable, 400);

            }
        };
        handler.post(runnable);


    }
    public void restartGame(View view){
        score = 0;
        scoreText.setText("Score: " + 0);
        resButton.setEnabled(false);
        startButton.setEnabled(false);
        /*Intent intent= getIntent();
        finish();
        startActivity(intent);*/
        hideImages();
        startButton.setEnabled(false);
        new CountDownTimer(10000,1000){

            @Override
            public void onTick(long l) {
                timeText.setText("Time: " + l/1000);

            }

            @Override
            public void onFinish() {
                highScore2();
                if(score>=10){
                    button4.setEnabled(true);
                }
                resButton.setEnabled(true);
                timeText.setText("Time Off!");
                handler.removeCallbacks(runnable);
                for(ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }
                /*AlertDialog.Builder alert= new AlertDialog.Builder(MainActivity2.this);
                alert.setTitle("Restart?");
                alert.setCancelable(false);
                alert.setMessage("Do you want to play again?");
                alert.setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Intent intent = new Intent();
                        finish();
                        try {
                            startActivity(intent);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity2.this, "Game Over!", Toast.LENGTH_LONG).show();
                    }
                });
                alert.show();*/



            }
        }.start();

    }
    public void start (View view){

        hideImages();
        startButton.setEnabled(false);
        resButton.setEnabled(false);
        new CountDownTimer(10000,1000){

            @Override
            public void onTick(long l) {
                timeText.setText("Time: " + l/1000);

            }

            @Override
            public void onFinish() {
                highScore2();
                if(score>=10){
                    button4.setEnabled(true);
                }
                resButton.setEnabled(true);
                timeText.setText("Time Off!");
                handler.removeCallbacks(runnable);
                for(ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }
                /*AlertDialog.Builder alert= new AlertDialog.Builder(MainActivity2.this);
                alert.setTitle("Restart?");
                alert.setCancelable(false);
                alert.setMessage("Do you want to play again?");
                alert.setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);

                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity2.this, "Game Over!", Toast.LENGTH_LONG).show();
                    }
                });
                alert.show();*/



            }
        }.start();

    }
    public void activityThird(View view) {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
        overridePendingTransition(R.anim.custom_fade_in, R.anim.custom_fade_out);
    }




}