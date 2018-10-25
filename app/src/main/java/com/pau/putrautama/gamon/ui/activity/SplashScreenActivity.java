package com.pau.putrautama.gamon.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pau.putrautama.gamon.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        startAnimation();
    }
//    public void onAttachedToWindow(){
//        super.onAttachedToWindow();
//        Window window = getWindow();
//        window.setFormat(PixelFormat.RGBA_8888);
//    }
    Thread splashThread;

    private void startAnimation(){
        splashThread = new Thread(){
            @Override
            public void run() {
                try {
                    int waited =0;
                    while (waited <3500){
                        sleep(100);
                        waited += 100;
                    }
                    Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    SplashScreenActivity.this.finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    SplashScreenActivity.this.finish();
                }
            }
        };
        splashThread.start();
    }
}
