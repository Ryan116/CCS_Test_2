package com.example.ccs_test_2.features.valuteFavoriteScreen.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.ccs_test_2.features.valuteFavoriteScreen.databinding.RecordBookmarkItemBinding
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.model.FavoriteCurrencyRateItem

class FavoriteAdapter(
    private val onItemClicked: (FavoriteCurrencyRateItem) -> Unit
) :
    ListAdapter<FavoriteCurrencyRateItem, FavoriteViewHolder>(FavoriteDiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoriteViewHolder {
        return FavoriteViewHolder(RecordBookmarkItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {

        val listItem = getItem(position)

        holder.bind(listItem)

        holder.bookmarkImageView.setOnClickListener {
            onItemClicked(listItem)
        }
    }
}



