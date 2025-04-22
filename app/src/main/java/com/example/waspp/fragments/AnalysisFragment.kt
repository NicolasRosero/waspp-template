package com.example.waspp.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity.MODE_PRIVATE
import androidx.fragment.app.Fragment
import com.example.waspp.R

class AnalysisFragment : Fragment() {
  // Propiedades del formulario
  private lateinit var inputNameAppliance: EditText;
  private lateinit var inputHoursOfDailyUse: EditText;
  private lateinit var inputPowerAppliance: EditText;
  private lateinit var inputElectricalCost: EditText;
  private lateinit var btnCalculate: Button;

  // Propiedades para manejar información de forma local
  private lateinit var sharedPreferences: SharedPreferences;

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view = inflater.inflate(R.layout.analysis_fragment, container, false);

    // Inicializar propiedades
    sharedPreferences = this.requireContext().getSharedPreferences("totalCostByApplianceTemp", MODE_PRIVATE);
    inputNameAppliance = view.findViewById(R.id.inputNameAppliance);
    inputHoursOfDailyUse = view.findViewById(R.id.inputHoursOfDailyUse);
    inputPowerAppliance = view.findViewById(R.id.inputPowerAppliance);
    inputElectricalCost = view.findViewById(R.id.inputElectricalCost);
    btnCalculate = view.findViewById(R.id.btnCalculateElectricaCost);

    btnCalculate.setOnClickListener {
      if(validateForm()) {
        calculateElectricalConsume();
      }
    };

    return view;
  }

  private fun calculateElectricalConsume() {
    val editor = sharedPreferences.edit();
    val hoursOfDailyUse = inputHoursOfDailyUse.text.toString().trim();
    val powerAppliance = inputPowerAppliance.text.toString().trim();
    val electricalCost = inputElectricalCost.text.toString().trim();
    val hours = hoursOfDailyUse.toIntOrNull() ?: 0;
    val power = powerAppliance.toIntOrNull() ?: 0;
    val cost = electricalCost.toIntOrNull() ?: 0;

    val dailyConsume = (power * hours) / 1000;
    val monthlyConsume = dailyConsume * 30;
    val monthlyCost = monthlyConsume * cost;

    editor.putString("dailyConsume", dailyConsume.toString());
    editor.putString("monthlyConsume", monthlyConsume.toString());
    editor.putString("monthlyCost", monthlyCost.toString());
    editor.apply();

    Toast
      .makeText(this.requireContext(), "Registro del consumo agregado en el histórico", Toast.LENGTH_SHORT)
      .show();
  }

  private fun validateForm(): Boolean {
    val nameAppliance = inputNameAppliance.text.toString().trim();
    val hoursOfDailyUse = inputHoursOfDailyUse.text.toString().trim();
    val powerAppliance = inputPowerAppliance.text.toString().trim();
    val electricalCost = inputElectricalCost.text.toString().trim();

    if(nameAppliance.isEmpty()) {
      Toast
        .makeText(this.requireContext(), "Debes ingresar el nombre del electrodoméstico", Toast.LENGTH_SHORT)
        .show();

      return false;
    }

    if(hoursOfDailyUse.isEmpty()) {
      Toast
        .makeText(this.requireContext(), "Debes ingresar las horas de uso diarias", Toast.LENGTH_SHORT)
        .show();

      return false;
    }

    if(powerAppliance.isEmpty()) {
      Toast
        .makeText(this.requireContext(), "Debes ingresar el poder del electrodoméstico", Toast.LENGTH_SHORT)
        .show();

      return false;
    }

    if(electricalCost.isEmpty()) {
      Toast
        .makeText(this.requireContext(), "Debes ingresar la tarifa eléctrica", Toast.LENGTH_SHORT)
        .show();

      return false;
    }

    return true;
  }
}