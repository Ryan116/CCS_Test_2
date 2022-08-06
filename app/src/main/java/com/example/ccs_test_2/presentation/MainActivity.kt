package com.example.ccs_test_2.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.ccs_test_2.R
import com.example.ccs_test_2.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupBottomBarNavigation()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setupBottomBarNavigation() {
        binding.bottomNavigationView.setOnItemSelectedListener { it ->
            when (it.itemId) {
                R.id.itemMainFragment -> {
                    findNavController(binding.fragmentContainerView.id).navigate(R.id.action_to_main_fragment)
                }
                R.id.itemFavoriteFragment -> {
                    findNavController(binding.fragmentContainerView.id).navigate(R.id.action_to_favorite_fragment)
                }
            }
            true
        }
    }
}