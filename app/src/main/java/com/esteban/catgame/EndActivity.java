package com.esteban.catgame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {

    private TextView scoreLabel, highScoreLabel;
    private Button buttonAgain;
    private String color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        scoreLabel = (TextView) findViewById(R.id.scoreLabel2);
        highScoreLabel = (TextView) findViewById(R.id.highScore);
        buttonAgain = (Button) findViewById(R.id.againButton);

        int score = getIntent().getIntExtra("SCORE", 0);
        color = getIntent().getStringExtra("color");

        scoreLabel.setText(score + "");

        SharedPreferences settings = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
        int highScore = settings.getInt("HIGH_SCORE", 0);

        if(score > highScore){
            highScoreLabel.setText("Mayor puntuación: " + score);

            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("HIGH_SCORE", score);
            editor.commit();
        } else {
            highScoreLabel.setText("Mayor puntuación: " + highScore);
        }

    }


    public void tryAgain(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("color",color);
        startActivity(intent);
    }

    public void close(View view) {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
