package com.slickiesbrand.realoops;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {

    ProgressBar mprogressbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView img = (ImageView) findViewById(R.id.imageView);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.animdown);
        img.setAnimation(anim);

        mprogressbar = (ProgressBar) findViewById(R.id.progressBar);
        ObjectAnimator animi = ObjectAnimator.ofInt(mprogressbar , "progress", 0,100);
        animi.setDuration(4000);
        animi.setInterpolator(new DecelerateInterpolator());
        animi.start();


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        },3000);


    }
}
