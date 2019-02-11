package com.example.danhnguyen.zoo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.media.MediaPlayer;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * @author Thanh Danh Nguyen
 */
public class TwoActivity extends AppCompatActivity {

    ImageView image1, image2, image3, imageMain, incorrect, correct;
    Button endGame, backGame;
    MediaPlayer backgroundmusic, wrong, correctsound;

    /**
     * List of colored images
     */
    Integer[] images = {
            R.drawable.animal_1,
            R.drawable.animal_2,
            R.drawable.animal_3,
            R.drawable.animal_4,
            R.drawable.animal_5,
            R.drawable.animal_6,
            R.drawable.animal_7,
            R.drawable.animal_8,
            R.drawable.animal_9,
            R.drawable.animal_10,
            R.drawable.animal_11,
            R.drawable.animal_12,
    };

    /**
     *List of black and white images
     */
    Integer[] images_bw = {
            R.drawable.animal_shadow_1,
            R.drawable.animal_shadow_2,
            R.drawable.animal_shadow_3,
            R.drawable.animal_shadow_4,
            R.drawable.animal_shadow_5,
            R.drawable.animal_shadow_6,
            R.drawable.animal_shadow_7,
            R.drawable.animal_shadow_8,
            R.drawable.animal_shadow_9,
            R.drawable.animal_shadow_10,
            R.drawable.animal_shadow_11,
            R.drawable.animal_shadow_12,
    };

    /**
     * Random array of images
     */
    Integer[] images_numbers = {
            0,
            1,
            2,
            3,
            4,
            5,
            6,
            7,
            8,
            9,
            10,
            11
    };

    /**
     * initialize turn and correctAnswer
     */
    int turn = 1;
    int correctAnswer = 0;

    /**
     * @param savedInstanceState
     * initialize images and main image and buttons
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);
        imageMain = (ImageView) findViewById(R.id.imageMain);
        endGame = (Button) findViewById(R.id.endGame);
        backGame = (Button) findViewById(R.id.backGame);
        incorrect = (ImageView) findViewById(R.id.incorrect);

        /**
         * initialize background music and sound effects
         * background music will be started right after starting game
         */
        backgroundmusic = MediaPlayer.create(TwoActivity.this, R.raw.backgroundmusic);
        backgroundmusic.setLooping(true);
        backgroundmusic.start();

        /**
         * initialize sound effect for wrong answers and correct answers
         */
        wrong = MediaPlayer.create(TwoActivity.this, R.raw.wrong);
        correctsound = MediaPlayer.create(TwoActivity.this, R.raw.correctsound);

        /**
         * call the array of images
         */
        Collections.shuffle(Arrays.asList(images_numbers));
        setImages();

        /**
         * existing game by clicking quit-button
         */
        endGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEnd();
            }
        });

        /**
         * back to the dashboard by clicking back-button
         */
        backGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(TwoActivity.this, UIActivity.class));
            }
        });

        image1.setOnClickListener(new View.OnClickListener() {

            /**
             * @param v
             * three of the images in list will be shown and one of them is matched with main image
             * if the chosen image is matched with main image ( correct )
             * new images will be set randomly and correct sound effect will be played
             * otherwise, wrong sound effect
             * images are able to choose again
             */
            @Override
            public void onClick(View v) {
                if (correctAnswer == 1) {
                    correctsound.start();
                    Collections.shuffle(Arrays.asList(images_numbers));
                    setImages();
                } else {
                    incorrect.setVisibility(View.VISIBLE);
                    incorrect.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            incorrect.setVisibility(View.INVISIBLE);
                        }
                    }, 1000);

                    wrong.start();
                }

                image1.setEnabled(true);
                image2.setEnabled(true);
                image3.setEnabled(true);
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {

            /**
             * @param v
             * three of the images in list will be shown and one of them is matched with main image
             * if the chosen image is matched with main image ( correct )
             * new images will be set randomly and correct sound effect will be played
             * otherwise, wrong sound effect
             * images are able to choose again
             */
            @Override
            public void onClick(View v) {
                if (correctAnswer == 2) {
                    correctsound.start();
                    Collections.shuffle(Arrays.asList(images_numbers));
                    setImages();

                } else {

                    incorrect.setVisibility(View.VISIBLE);
                    incorrect.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            incorrect.setVisibility(View.INVISIBLE);
                        }
                    }, 1000);

                    wrong.start();

                }

                image1.setEnabled(true);
                image2.setEnabled(true);
                image3.setEnabled(true);
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {

            /**
             * @param v
             * three of the images in list will be shown and one of them is matched with main image
             * if the chosen image is matched with main image ( correct )
             * new images will be set randomly and correct sound effect will be played
             * otherwise, wrong sound effect
             * images are able to choose again
             */
            @Override
            public void onClick(View v) {
                if (correctAnswer == 3) {
                    correctsound.start();
                    Collections.shuffle(Arrays.asList(images_numbers));
                    setImages();

                } else {
                    incorrect.setVisibility(View.VISIBLE);
                    incorrect.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            incorrect.setVisibility(View.INVISIBLE);
                        }
                    }, 1000);
                    wrong.start();
                }

                image1.setEnabled(true);
                image2.setEnabled(true);
                image3.setEnabled(true);
            }
        });

    }

    /**
     * the correct image will be randomed within 3 choice-images
     * if correct, the images will be set again randomly and be able to created a new round
     */
    private void setImages() {
        Random r = new Random();
        correctAnswer = r.nextInt(3) + 1;

        int wrongAnswer1, wrongAnswer2;

        do {
            wrongAnswer1 = r.nextInt(12);
        } while (wrongAnswer1 == images_numbers[turn]);

        do {
            wrongAnswer2 = r.nextInt(12);
        } while (wrongAnswer2 == images_numbers[turn] || wrongAnswer2 == wrongAnswer1);


        switch (correctAnswer) {
            case 1:
                image1.setImageResource(images_bw[images_numbers[turn]]);
                image2.setImageResource(images_bw[wrongAnswer1]);
                image3.setImageResource(images_bw[wrongAnswer2]);


                break;
            case 2:
                image1.setImageResource(images_bw[wrongAnswer1]);
                image2.setImageResource(images_bw[images_numbers[turn]]);
                image3.setImageResource(images_bw[wrongAnswer2]);

                break;
            case 3:
                image1.setImageResource(images_bw[wrongAnswer1]);
                image2.setImageResource(images_bw[wrongAnswer2]);
                image3.setImageResource(images_bw[images_numbers[turn]]);

                break;
        }

        /**
         * set the main image
         * and the three choice-image which are able to be clicked
         */
        imageMain.setImageResource(images[images_numbers[turn]]);

        image1.setEnabled(true);
        image2.setEnabled(true);
        image3.setEnabled(true);
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