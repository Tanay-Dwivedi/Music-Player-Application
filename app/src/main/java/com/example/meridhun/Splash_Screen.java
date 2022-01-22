package com.example.meridhun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash_Screen extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5000;

    //variables
    Animation logoAnim, textAnim, textAnimBottom;
    ImageView logo;
    TextView app_name, slogan, made_by, powered;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        //animations settings
        logoAnim = AnimationUtils.loadAnimation(this, R.anim.logo_animation);
        textAnim = AnimationUtils.loadAnimation(this, R.anim.text_animation);
        textAnimBottom = AnimationUtils.loadAnimation(this, R.anim.text_animation_bottom_ones);

        //hooking
        logo = findViewById(R.id.imageView);
        app_name = findViewById(R.id.textView);
        slogan = findViewById(R.id.textView2);
        made_by = findViewById(R.id.textView3);
        powered = findViewById(R.id.textView4);

        //adding animations to the views
        logo.setAnimation(logoAnim);
        app_name.setAnimation(textAnim);
        slogan.setAnimation(textAnim);
        made_by.setAnimation(textAnimBottom);
        powered.setAnimation(textAnimBottom);

        //going to next screen after splashing
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash_Screen.this, ListScreen.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN );

    }
}