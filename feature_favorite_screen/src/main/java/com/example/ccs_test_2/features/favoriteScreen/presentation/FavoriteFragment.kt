package com.example.ccs_test_2.features.favoriteScreen.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ccs_test_2.features.valuteFavoriteScreen.databinding.FragmentFavoriteBinding
import com.example.ccs_test_2.features.favoriteScreen.presentation.adapter.FavoriteAdapter
import com.example.ccs_test_2.features.valuteFavoriteScreen.presentation.viewModel.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding
        get() = _binding!!

    private val favoriteViewModel: FavoriteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapter()

        binding.floatingActionButton.setOnClickListener {
            favoriteViewModel.deleteAllBookmarks()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupAdapter() {

        val adapterBookmark = FavoriteAdapter() { favoriteCurrencyItemDomain ->
            favoriteViewModel.deleteBookmark(favoriteCurrencyItemDomain)
        }

        binding.recyclerViewFavorite.apply {
            adapter = adapterBookmark
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }

        lifecycleScope.launch {
            favoriteViewModel.listFavoriteCurrencyRate.collect { listFavoriteCurrencyItemDomain ->
                adapterBookmark.submitList(listFavoriteCurrencyItemDomain)
            }
        }
    }
}