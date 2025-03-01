package com.example.waspp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ResetPasswordActivity : AppCompatActivity() {
  // Propiedades del formulario
  private lateinit var inputTextEmail: EditText;
  private lateinit var btnResetPassword: Button;

  // Propiedades para manejar información de forma local
  private lateinit var sharedPreferences: SharedPreferences;

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.reset_password_activity)

    // Inicializar almacenamiento temporal
    sharedPreferences = getSharedPreferences("UserDataTemp", MODE_PRIVATE)

    // Inicializar variables del formulario
    inputTextEmail = findViewById(R.id.inputUserEmailResetP);
    btnResetPassword = findViewById(R.id.btnResetPassword);

    btnResetPassword.setOnClickListener {
      if(validateForm()) {
        validetEmail();
      }
    };
  }

  private fun validateForm(): Boolean {
    val userEmail = inputTextEmail.text.toString().trim();

    if(userEmail.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
      Toast
        .makeText(this, "Debes ingresar un correo valido para continuar", Toast.LENGTH_SHORT)
        .show();

      return false;
    }

    return true;
  }

  private fun validetEmail() {
    val email = inputTextEmail.text.toString().trim();
    val emailInDB = sharedPreferences.getString("userEmail", "");

    if(email == emailInDB) {
      Toast
        .makeText(this, "Correo de recuperación enviado correctamente 📧", Toast.LENGTH_SHORT)
        .show();

      btnResetPassword.postDelayed({
        startActivity(
          Intent(this, LoginActivity::class.java)
        );
        finish();
      }, 2000);
    } else {
      Toast
        .makeText(this, "No hemos encontrado un correo que coincida con el ingresado", Toast.LENGTH_SHORT)
        .show();
    }
  }

  fun returnToLogin(view: View?) {
    startActivity(
      Intent(this, LoginActivity::class.java)
    );
    finish();
  }

  override fun onStart() {
    super.onStart()

    Log.d("ResetPasswordActivity", "onStart: ResetPasswordActivity está en segundo plano");
  }

  override fun onResume() {
    super.onResume()

    Log.d("ResetPasswordActivity", "onResume: Entro en onResume");
  }

  override fun onStop() {
    super.onStop()

    Log.d("ResetPasswordActivity", "onStop: Entro en onStop");
  }

  override fun onPause() {
    super.onPause()

    Log.d("ResetPasswordActivity", "onPause: Entro en onPause");
  }

  override fun onDestroy() {
    super.onDestroy()

    Log.d("ResetPasswordActivity", "onDestroy: Entro en onDestroy");
  }
}