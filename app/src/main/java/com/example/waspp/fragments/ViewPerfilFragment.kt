package com.example.waspp.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity.MODE_PRIVATE
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.waspp.R

class ViewPerfilFragment : Fragment() {
  // Propiedades del formulario
  private lateinit var inputTextName: EditText;
  private lateinit var inputTextLastName: EditText;
  private lateinit var inputTextEmail: EditText;
  private lateinit var inputTextPhoneNumber: EditText;
  private lateinit var inputTextAcademicProgram: EditText;
  private lateinit var inputTextSemester: EditText;
  private lateinit var btnGoToEdit: Button;

  // Propiedades para manejar información de forma local
  private lateinit var sharedPreferences: SharedPreferences;

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view = inflater.inflate(R.layout.view_perfil_fragment, container, false);
    sharedPreferences = this.requireContext().getSharedPreferences("UserDataTemp", MODE_PRIVATE);

    // Inicializar variables
    inputTextName = view.findViewById(R.id.inputUserNamePerfilView);
    inputTextLastName = view.findViewById(R.id.inputUserLastNamePerfilView);
    inputTextEmail = view.findViewById(R.id.inputUserEmailPerfilView);
    inputTextPhoneNumber = view.findViewById(R.id.inputUserPhonePerfilView);
    inputTextAcademicProgram = view.findViewById(R.id.inputUserAcademicProgramPerfilView);
    inputTextSemester = view.findViewById(R.id.inputUserSemesterPerfilView);
    btnGoToEdit = view.findViewById(R.id.btnEditInfoUserView);

    // Establecer los valores en los inputs
    inputTextName.setText(sharedPreferences.getString("userName", ""));
    inputTextLastName.setText(sharedPreferences.getString("userLastName", ""));
    inputTextEmail.setText(sharedPreferences.getString("userEmail", ""));
    inputTextPhoneNumber.setText(sharedPreferences.getString("userPhone", ""));
    inputTextAcademicProgram.setText(sharedPreferences.getString("userAcademicProgram", ""));
    inputTextSemester.setText("Ubicación semestral: " + sharedPreferences.getString("userSemester", ""));

    btnGoToEdit.setOnClickListener {
      findNavController().navigate(R.id.perfilEditFragmentOption);
    }

    return view;
  }
}