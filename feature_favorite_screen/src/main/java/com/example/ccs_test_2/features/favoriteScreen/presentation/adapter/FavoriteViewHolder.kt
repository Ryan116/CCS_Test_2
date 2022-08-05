package com.example.ccs_test_2.features.favoriteScreen.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.ccs_test_2.features.favoriteScreen.domain.model.FavoriteCurrencyRateItem
import com.example.ccs_test_2.features.valuteFavoriteScreen.databinding.FavoriteItemBinding

class FavoriteViewHolder(private var binding: FavoriteItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    val bookmarkImageView = binding.imageViewFavorite2

    fun bind(favoriteCurrencyRateItem: FavoriteCurrencyRateItem) {
        binding.apply {
            textViewDateFavorite.text = favoriteCurrencyRateItem.date
            textViewNominalFavorite.text = favoriteCurrencyRateItem.nominal.toString()
            textViewValueFavorite.text = favoriteCurrencyRateItem.value
            textViewCurrencyNameFavorite.text = favoriteCurrencyRateItem.currencyName
        }
    }
}





