package com.example.waspp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity;

class SplashActivity : AppCompatActivity() {
  private var SPLASH_TIME_OUT: Long = 2000;

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState);

    // Mostrar una vista o layout :0
    setContentView(R.layout.splash_activity);

    // Llevar a MainActivity
    Handler(mainLooper).postDelayed({
      startActivity(
        Intent(this, WelcomeActivity::class.java).apply {
          Intent.FLAG_ACTIVITY_SINGLE_TOP
        }
      );
      finish();
    }, SPLASH_TIME_OUT);
  }
}