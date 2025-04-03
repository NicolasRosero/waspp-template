package com.example.waspp.activities

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.waspp.R

class PerfilActivity : AppCompatActivity() {
  // Propiedades del formulario
  private lateinit var inputTextName: EditText;
  private lateinit var inputTextLastName: EditText;
  private lateinit var inputTextEmail: EditText;
  private lateinit var inputTextPhoneNumber: EditText;

  // Propiedades para manejar información de forma local
  private lateinit var sharedPreferences: SharedPreferences;

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContentView(R.layout.perfil_activity);

    sharedPreferences = getSharedPreferences("UserDataTemp", MODE_PRIVATE);

    // Inicializar variables
    inputTextName = findViewById(R.id.inputUserNamePerfil);
    inputTextLastName = findViewById(R.id.inputUserLastNamePerfil);
    inputTextEmail = findViewById(R.id.inputUserEmailPerfil);
    inputTextPhoneNumber = findViewById(R.id.inputUserPhonePerfil);

    // Establecer los valores en los inputs
    inputTextName.setText(sharedPreferences.getString("userName", ""));
    inputTextLastName.setText(sharedPreferences.getString("userLastName", ""));
    inputTextEmail.setText(sharedPreferences.getString("userEmail", ""));
    inputTextPhoneNumber.setText(sharedPreferences.getString("userPhone", ""));
  }

  override fun onStart() {
    super.onStart()

    Log.d("PerfilActivity", "onStart: PerfilActivity está en segundo plano");
  }

  override fun onResume() {
    super.onResume()

    Log.d("PerfilActivity", "onResume: Entro en onResume");
  }

  override fun onStop() {
    super.onStop()

    Log.d("PerfilActivity", "onStop: Entro en onStop");
  }

  override fun onPause() {
    super.onPause()

    Log.d("PerfilActivity", "onPause: Entro en onPause");
  }

  override fun onDestroy() {
    super.onDestroy()

    Log.d("PerfilActivity", "onDestroy: Entro en onDestroy");
  }
}