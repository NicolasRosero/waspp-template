package com.example.waspp.activities

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.waspp.R

class RegisterActivity : AppCompatActivity() {
  //Propiedades del formulario
  private lateinit var inputTextName: EditText;
  private lateinit var inputTextLastName: EditText;
  private lateinit var inputTextEmail: EditText;
  private lateinit var inputTextPhoneNumber: EditText;
  private lateinit var inputTextAcademicProgram: EditText;
  private lateinit var inputTextSemester: EditText;
  private lateinit var inputTextPassword: EditText;
  private lateinit var inputTextConfirmPassword: EditText;
  private lateinit var checkBoxTermsAndConditions: CheckBox;
  private lateinit var btnRegisterNewUser: Button;

  // Propiedades para manejar información de forma local
  private lateinit var sharedPreferences: SharedPreferences;

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    Log.d("RegisterActivity", "onCreate: Entro en onCreate");

    setContentView(R.layout.register_activity);

    // Inicializar almacenamiento temporal
    sharedPreferences = getSharedPreferences("UserDataTemp", MODE_PRIVATE);

    // Inicializar variables
    inputTextName = findViewById(R.id.inputUserName);
    inputTextLastName = findViewById(R.id.inputUserLastName);
    inputTextEmail = findViewById(R.id.inputUserEmail);
    inputTextPhoneNumber = findViewById(R.id.inputUserPhone);
    inputTextAcademicProgram = findViewById(R.id.inputUserAcademicProgram);
    inputTextSemester = findViewById(R.id.inputUserSemester);
    inputTextPassword = findViewById(R.id.inputUserPassword);
    inputTextConfirmPassword = findViewById(R.id.inputUserConfirmPassword);
    checkBoxTermsAndConditions = findViewById(R.id.checkUserTerms);

    btnRegisterNewUser = findViewById(R.id.btnCreateNewUser);

    // Validar información
    btnRegisterNewUser.setOnClickListener {
      if(validateForm()) {
        saveNewUser();
      }
    };
  }

  private fun validateForm(): Boolean {
    val userName = inputTextName.text.toString().trim();
    val userLastName = inputTextLastName.text.toString().trim();
    val userEmail = inputTextEmail.text.toString().trim();
    val userPhone = inputTextPhoneNumber.text.toString().trim();
    val userAcademicProgram = inputTextAcademicProgram.text.toString().trim();
    val userSemester = inputTextSemester.text.toString().trim();
    val userPassword = inputTextPassword.text.toString().trim();
    val userConfirmPassword = inputTextConfirmPassword.text.toString().trim();
    val termsAndConditions = checkBoxTermsAndConditions.isChecked;

    if(userName.isEmpty()) {
      Toast
        .makeText(this, "Debes ingresar tu nombre para continuar", Toast.LENGTH_SHORT)
        .show();

      return false;
    }

    if(userLastName.isEmpty()) {
      Toast
        .makeText(this, "Debes ingresar tu/s apellido/s para continuar", Toast.LENGTH_SHORT)
        .show();

      return false;
    }

    if(userEmail.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
      Toast
        .makeText(this, "Debes ingresar un correo valido para continuar", Toast.LENGTH_SHORT)
        .show();

      return false;
    }

    if(userPhone.isEmpty()) {
      Toast
        .makeText(this, "Debes ingresar un número de celular para continuar", Toast.LENGTH_SHORT)
        .show();

      return false;
    }

    if(userAcademicProgram.isEmpty()) {
      Toast
        .makeText(this, "Debes ingresar tu programa académico para continuar", Toast.LENGTH_SHORT)
        .show();

      return false;
    }

    if(userSemester.isEmpty()) {
      Toast
        .makeText(this, "Debes ingresar tu ubicación semestral para continuar", Toast.LENGTH_SHORT)
        .show();

      return false;
    }

    if(userPassword.isEmpty()) {
      Toast
        .makeText(this, "Debes ingresar una contraseña para continuar", Toast.LENGTH_SHORT)
        .show();

      return false;
    }

    if(userConfirmPassword.isEmpty()) {
      Toast
        .makeText(this, "Debes confirmar tu contraseña para continuar", Toast.LENGTH_SHORT)
        .show();

      return false;
    }

    if(userPassword != userConfirmPassword) {
      Toast
        .makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT)
        .show();

      return false;
    }

    if(!termsAndConditions) {
      Toast
        .makeText(this, "Debes aceptar los términos y condiciones para continuar", Toast.LENGTH_SHORT)
        .show();

      return false;
    }

    return true;
  }

  private fun saveNewUser() {
    val editor = sharedPreferences.edit();

    // Establecer valores en el "almacenamiento local"
    editor.putString("userName", inputTextName.text.toString().trim());
    editor.putString("userLastName", inputTextLastName.text.toString().trim());
    editor.putString("userEmail", inputTextEmail.text.toString().trim());
    editor.putString("userPhone", inputTextPhoneNumber.text.toString().trim());
    editor.putString("userAcademicProgram", inputTextAcademicProgram.text.toString().trim());
    editor.putString("userSemester", inputTextSemester.text.toString().trim());
    editor.putString("userPassword", inputTextPassword.text.toString().trim());
    editor.putString("userHasAcceptedTerms", checkBoxTermsAndConditions.isChecked.toString().trim());

    // Guardar información
    editor.apply();

    Log.d("RegisterActivity", "saveNewUser: Datos del usuario guardados!");

    // Mostrar mensaje de registro
    Toast
      .makeText(this, "Registro exitoso 😀", Toast.LENGTH_SHORT)
      .show();

    // Llevar al LoginActivity
    startActivity(
      Intent(this, LoginActivity::class.java)
    );
    finish();
  }

  fun goToLogin(view: View?) {
    startActivity(
      Intent(this, LoginActivity::class.java)
    );
    finish();
  }

  override fun onStart() {
    super.onStart()

    Log.d("RegisterActivity", "onStart: RegisterActivity está en segundo plano");
  }

  override fun onResume() {
    super.onResume()

    Log.d("RegisterActivity", "onResume: Entro en onResume");
  }

  override fun onStop() {
    super.onStop()

    Log.d("RegisterActivity", "onStop: Entro en onStop");
  }

  override fun onPause() {
    super.onPause()

    Log.d("RegisterActivity", "onPause: Entro en onPause");
  }

  override fun onDestroy() {
    super.onDestroy()

    Log.d("RegisterActivity", "onDestroy: Entro en onDestroy");
  }
}