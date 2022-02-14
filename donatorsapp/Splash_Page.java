package com.example.donatorsapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Splash_Page extends AppCompatActivity {
    private static int  Splash_Screen=3000;
ImageView logo;
TextView emri;
Animation anim;
ImageView bckg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_page);
        emri= findViewById(R.id.app_name);
        logo= findViewById(R.id.logo);
        bckg=findViewById(R.id.bckg);

        anim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        emri.setAnimation(anim);
        logo.setAnimation(anim);
        bckg.setAnimation(anim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(Splash_Page.this,  Login_Page.class);
                startActivity(intent);
                finish();
            }
        },Splash_Screen);

    }
}