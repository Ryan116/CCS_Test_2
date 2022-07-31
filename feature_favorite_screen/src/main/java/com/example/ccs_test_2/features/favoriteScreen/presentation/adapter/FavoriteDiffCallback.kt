package com.example.ccs_test_2.features.favoriteScreen.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.ccs_test_2.features.favoriteScreen.domain.model.FavoriteCurrencyRateItem

class FavoriteDiffCallback:DiffUtil.ItemCallback<FavoriteCurrencyRateItem>() {

    override fun areItemsTheSame(oldItem: FavoriteCurrencyRateItem, newItem: FavoriteCurrencyRateItem): Boolean {
        return oldItem.value == newItem.value
    }

    override fun areContentsTheSame(oldItem: FavoriteCurrencyRateItem, newItem: FavoriteCurrencyRateItem): Boolean {
        return oldItem == newItem
    }
}