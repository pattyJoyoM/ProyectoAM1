package com.example.patty.proyectoandroid_joyomendezpatricia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by PATTY on 18/06/2017.
 */

public class SplashActivity extends AppCompatActivity {
    private static final long SPLASH_SCREEN_DELAY = 4000;
    ImageView icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        };

        icon = (ImageView)findViewById(R.id.imgIcon);

        Animation fall;

        fall = AnimationUtils.loadAnimation(this,R.anim.top_to_center);

        icon.startAnimation(fall);

        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);


    }
}
