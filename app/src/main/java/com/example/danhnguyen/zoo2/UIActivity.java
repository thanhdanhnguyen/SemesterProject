package com.example.danhnguyen.zoo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.media.MediaPlayer;

/**
 * @author Thanh Danh Nguyen
 */
public class UIActivity extends AppCompatActivity {
    Button endGame, level1, level2;
    MediaPlayer backgroundmusic, wrong, correctsound;

    /**
     * @param savedInstanceState
     * initialize the buttons and their functions
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);

        level1 = (Button) findViewById(R.id.level1);
        level2 = (Button) findViewById(R.id.level2);
        endGame = (Button) findViewById(R.id.endGame);

        /**
         *initialize music background which will be played automatically right after sphlash screen
         */
        backgroundmusic = MediaPlayer.create(UIActivity.this, R.raw.backgroundmusic);
        backgroundmusic.setLooping(true);
        backgroundmusic.start();

        /**
         * leading into level 1 by clicking level1-button
         */
        level1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(UIActivity.this, OneActivity.class));
            }
        });

        /**
         * leading into level 2 by cliking level2-button
         */
        level2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(UIActivity.this, TwoActivity.class));
            }
        });

        /**
         * existing game by clicking quit-button
         */
        endGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEnd();
            }
        });
    }

    /**
     * background music will be stopped when back to home screen
     */
    @Override
    protected void onPause() {
        if (backgroundmusic.isPlaying()) {
            backgroundmusic.pause();
        }
        super.onPause();
    }

    /**
     * background music will be played again when back to the game
     */
    @Override
    protected void onResume() {
        super.onResume();
        backgroundmusic.start();
    }

    /**
     * exist game and stop playing background music
     */
    private void checkEnd() {
        backgroundmusic.release();
        finish();
    }
}