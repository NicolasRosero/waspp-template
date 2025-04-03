package com.example.waspp.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity;
import com.example.waspp.R

class SplashActivity : AppCompatActivity() {
  private val SPLASH_TIME_OUT: Long = 2000;

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState);

    // Mostrar una vista o layout :0
    setContentView(R.layout.splash_activity);

    // Llevar a MainActivity
    Handler(mainLooper).postDelayed({
      startActivity(
        Intent(this, WelcomeActivity::class.java)
      );
      finish();
    }, SPLASH_TIME_OUT);
  }

  override fun onStart() {
    super.onStart()

    Log.d("SplashActiviy", "onStart: SplashActivity está en segundo plano");
  }

  override fun onResume() {
    super.onResume()

    Log.d("SplashActiviy", "onResume: Entro en onResume");
  }

  override fun onStop() {
    super.onStop()

    Log.d("SplashActiviy", "onStop: Entro en onStop");
  }

  override fun onPause() {
    super.onPause()

    Log.d("SplashActiviy", "onPause: Entro en onPause");
  }

  override fun onDestroy() {
    super.onDestroy()

    Log.d("SplashActiviy", "onDestroy: Entro en onDestroy");
  }
}