package com.example.truth_and_dare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
   ImageView imageView;
   Button button;
   int lastDirection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.buttonspin);
    }
    public void spin(View view){
        Random random = new Random();
        int  startpoint;
        float pivotx, pivoty;
        startpoint = random.nextInt(3600)+360;
        pivotx = imageView.getWidth()/2;
        pivoty = imageView.getHeight()/2;
        Animation rotation = new RotateAnimation(lastDirection, startpoint, pivotx, pivoty);
        rotation.setDuration(2000);
        rotation.setFillAfter(true);

        rotation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                button.setEnabled(false);

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                 button.setEnabled(true);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        lastDirection = startpoint;

        imageView.startAnimation(rotation);

    }
}