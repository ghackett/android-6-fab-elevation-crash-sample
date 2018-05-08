package com.example.testapp;

import android.animation.ValueAnimator;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  @Override
  protected void onPostResume() {
    super.onPostResume();

    final FloatingActionButton fab = findViewById(R.id.fab);
    ValueAnimator animator = ValueAnimator.ofFloat(0f, 300f)
        .setDuration(3000L);

    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override
      public void onAnimationUpdate(ValueAnimator animation) {
        float animatedValue = (float) animation.getAnimatedValue();

        // this line crashes on android 6.0 and android 5.1
        fab.setCompatElevation(animatedValue);
      }
    });

    animator.start();
  }
}
