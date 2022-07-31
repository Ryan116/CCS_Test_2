package com.example.ccs_test_2.features.valuteFavoriteScreen.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.ccs_test_2.features.valuteFavoriteScreen.databinding.RecordBookmarkItemBinding
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.model.FavoriteCurrencyRateItem

class FavoriteViewHolder(private var binding: RecordBookmarkItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    val bookmarkImageView = binding.imageViewFavorite2

    fun bind(favoriteCurrencyRateItem: FavoriteCurrencyRateItem) {

        binding.apply {
            textViewDateFavorite.text = favoriteCurrencyRateItem.date
            textViewNominalFavorite.text = favoriteCurrencyRateItem.nominal.toString()
            textViewValueFavorite.text = favoriteCurrencyRateItem.value
        }

    }
}





