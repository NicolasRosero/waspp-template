package com.example.waspp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.waspp.R

class HistoryFragment : Fragment() {
  private lateinit var applianceTextView: TextView;
  private lateinit var dailyConsumeView: TextView;
  private lateinit var monthlyConsumeTextView: TextView;
  private lateinit var totalCostTextView: TextView;

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view = inflater.inflate(R.layout.history_fragment, container, false);

    return view;
  }
}