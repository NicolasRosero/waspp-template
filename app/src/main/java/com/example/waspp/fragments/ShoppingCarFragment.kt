package com.example.waspp.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity.MODE_PRIVATE
import androidx.fragment.app.Fragment
import com.example.waspp.R

class ShoppingCarFragment : Fragment() {
  private lateinit var totalProductsInCarLabel: TextView;
  private lateinit var sharedPreferences: SharedPreferences;

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view = inflater.inflate(R.layout.shopping_car_fragment, container, false);

    totalProductsInCarLabel = view.findViewById(R.id.totalProductsInCar);
    sharedPreferences = this.requireContext().getSharedPreferences("ShoppingCarDataTemp", MODE_PRIVATE);

    totalProductsInCarLabel.setText(sharedPreferences.getString("productsInShoppingCar", "0"));

    return view;
  }
}