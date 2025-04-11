package com.example.waspp.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity.MODE_PRIVATE
import androidx.fragment.app.Fragment
import com.example.waspp.R

class ProductsFragment : Fragment() {
  private lateinit var btnAddProductToShoppingCar: Button;
  private lateinit var sharedPreferences: SharedPreferences;

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view = inflater.inflate(R.layout.products_fragment, container, false);
    var count = 0;

    // Inicializar propiedades
    btnAddProductToShoppingCar = view.findViewById(R.id.addToShoppingCar);
    sharedPreferences = this.requireContext().getSharedPreferences("ShoppingCarDataTemp", MODE_PRIVATE);

    btnAddProductToShoppingCar.setOnClickListener{
      count += 1;

      val editor = sharedPreferences.edit();

      editor.putString("productsInShoppingCar", count.toString());
      editor.apply();
    }

    return view;
  }
}