package com.example.waspp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.waspp.R

class CategoriesFragment : Fragment() {
  private lateinit var homeCategoryContainer: View;
  private lateinit var homeCategoryImg: ImageView;
  private lateinit var clothesCategoryContainer: View;
  private lateinit var clothesCategoryImg: ImageView;
  private lateinit var techCategoryContainer: View;
  private lateinit var techCategoryImg: ImageView;
  private lateinit var sportsCategoryContainer: View;
  private lateinit var sportsCategoryImg: ImageView;
  private lateinit var accessoriesCategoryContainer: View;
  private lateinit var accessoriesCategoryImg: ImageView;

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view = inflater.inflate(R.layout.categories_fragment, container, false);

    // Inicialización de propiedades
    homeCategoryContainer = view.findViewById(R.id.cardContainerCategory1);
    homeCategoryImg = view.findViewById(R.id.homeCategoryImg);
    clothesCategoryContainer = view.findViewById(R.id.cardContainerCategory2);
    clothesCategoryImg = view.findViewById(R.id.clothesCategoryImg);
    techCategoryContainer = view.findViewById(R.id.cardContainerCategory3);
    techCategoryImg = view.findViewById(R.id.technologyCategoryImg);
    sportsCategoryContainer = view.findViewById(R.id.cardContainerCategory4);
    sportsCategoryImg = view.findViewById(R.id.sportsCategoryImg);
    accessoriesCategoryContainer = view.findViewById(R.id.cardContainerCategory5);
    accessoriesCategoryImg = view.findViewById(R.id.accessoriesCategoryImg);


    homeCategoryContainer.setOnClickListener {
      findNavController().navigate(R.id.homeCategoryFragmentOption);
    }

    homeCategoryImg.setOnClickListener {
      findNavController().navigate(R.id.homeCategoryFragmentOption);
    }

    clothesCategoryContainer.setOnClickListener {
      findNavController().navigate(R.id.clothesCategoryFragmentOption);
    }

    clothesCategoryImg.setOnClickListener {
      findNavController().navigate(R.id.clothesCategoryFragmentOption);
    }

    techCategoryContainer.setOnClickListener {
      findNavController().navigate(R.id.technologyCategoryFragmentOption);
    }

    techCategoryImg.setOnClickListener {
      findNavController().navigate(R.id.technologyCategoryFragmentOption);
    }

    sportsCategoryContainer.setOnClickListener {
      findNavController().navigate(R.id.sportsCategoryFragmentOption);
    }

    sportsCategoryImg.setOnClickListener {
      findNavController().navigate(R.id.sportsCategoryFragmentOption);
    }

    accessoriesCategoryContainer.setOnClickListener {
      findNavController().navigate(R.id.accessoriesCategoryFragmentOption);
    }

    accessoriesCategoryImg.setOnClickListener {
      findNavController().navigate(R.id.accessoriesCategoryFragmentOption);
    }

    return view;
  }
}