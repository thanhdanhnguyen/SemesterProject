package com.example.danhnguyen.zoo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

/**
 * @author Thanh Danh Nguyen
 */
public class SplashScreenActivity extends AppCompatActivity {

    /**
     * @param savedInstanceState
     * splashscreen will be played automatically after runing app and will take 4 seconds
     * and then lead into dashboard
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
       Thread myThread = new Thread(){
           @Override
           public void run(){
               try{
                   sleep(4000);
                   Intent intent = new Intent(getApplicationContext(),UIActivity.class);
                   startActivity(intent);
                   finish();
               }catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       };
       myThread.start();
    }
}
