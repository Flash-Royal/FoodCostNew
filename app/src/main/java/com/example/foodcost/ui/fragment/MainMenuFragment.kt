package com.example.foodcost.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodcost.R
import com.example.foodcost.databinding.FragmentMainMenuBinding

class MainMenuFragment : Fragment() {

    private var newBinding: FragmentMainMenuBinding? = null
    private val binding get() = newBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        newBinding = FragmentMainMenuBinding.inflate(layoutInflater)
        return binding.root
    }

}