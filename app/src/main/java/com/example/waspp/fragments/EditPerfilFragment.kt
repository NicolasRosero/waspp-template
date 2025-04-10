package com.example.waspp.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity.MODE_PRIVATE
import androidx.navigation.fragment.findNavController
import com.example.waspp.R

class EditPerfilFragment : Fragment() {
  // Propiedades del formulario
  private lateinit var inputTextName: EditText;
  private lateinit var inputTextLastName: EditText;
  private lateinit var inputTextEmail: EditText;
  private lateinit var inputTextPhoneNumber: EditText;
  private lateinit var btnSaveInfo: Button;

  // Propiedades para manejar información de forma local
  private lateinit var sharedPreferences: SharedPreferences;

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view = inflater.inflate(R.layout.edit_perfil_fragment, container, false);

    sharedPreferences = this.requireContext().getSharedPreferences("UserDataTemp", MODE_PRIVATE);

    // Inicializar variables
    inputTextName = view.findViewById(R.id.inputUserNamePerfil);
    inputTextLastName = view.findViewById(R.id.inputUserLastNamePerfil);
    inputTextEmail = view.findViewById(R.id.inputUserEmailPerfil);
    inputTextPhoneNumber = view.findViewById(R.id.inputUserPhonePerfil);
    btnSaveInfo = view.findViewById(R.id.btnEditInfoUser)

    // Establecer los valores en los inputs
    inputTextName.setText(sharedPreferences.getString("userName", ""));
    inputTextLastName.setText(sharedPreferences.getString("userLastName", ""));
    inputTextEmail.setText(sharedPreferences.getString("userEmail", ""));
    inputTextPhoneNumber.setText(sharedPreferences.getString("userPhone", ""));

    btnSaveInfo.setOnClickListener {
      if(validateForm()) {
        editUser();
      }
    }

    return view;
  }

  private fun validateForm(): Boolean {
    val userName = inputTextName.text.toString().trim();
    val userLastName = inputTextLastName.text.toString().trim();
    val userEmail = inputTextEmail.text.toString().trim();
    val userPhone = inputTextPhoneNumber.text.toString().trim();

    if(userName.isEmpty()) {
      Toast
        .makeText(this.requireContext(), "Debes ingresar tu nombre para continuar", Toast.LENGTH_SHORT)
        .show();

      return false;
    }

    if(userLastName.isEmpty()) {
      Toast
        .makeText(this.requireContext(), "Debes ingresar tu/s apellido/s para continuar", Toast.LENGTH_SHORT)
        .show();

      return false;
    }

    if(userEmail.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
      Toast
        .makeText(this.requireContext(), "Debes ingresar un correo valido para continuar", Toast.LENGTH_SHORT)
        .show();

      return false;
    }

    if(userPhone.isEmpty()) {
      Toast
        .makeText(this.requireContext(), "Debes ingresar un número de celular para continuar", Toast.LENGTH_SHORT)
        .show();

      return false;
    }

    return true;
  }

  private fun editUser() {
    val editor = sharedPreferences.edit();

    // Establecer valores en el "almacenamiento local"
    editor.putString("userName", inputTextName.text.toString().trim());
    editor.putString("userLastName", inputTextLastName.text.toString().trim());
    editor.putString("userEmail", inputTextEmail.text.toString().trim());
    editor.putString("userPhone", inputTextPhoneNumber.text.toString().trim());

    // Guardar información
    editor.apply();

    // Mostrar mensaje de registro
    Toast
      .makeText(this.requireContext(), "Registro exitoso 😀", Toast.LENGTH_SHORT)
      .show();

    findNavController().navigate(R.id.perfilFragmentOption);
  }
}