package com.example.waspp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContentView(R.layout.welcome_activity);
  }

  fun gotToLogin(view: View?) {
    startActivity(
      Intent(this, LoginActivity::class.java).apply {
        Intent.FLAG_ACTIVITY_SINGLE_TOP
      }
    );
    finish();
  };
}