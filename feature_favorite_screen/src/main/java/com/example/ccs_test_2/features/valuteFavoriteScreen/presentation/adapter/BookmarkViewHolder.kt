package com.example.ccs_test_2.features.valuteFavoriteScreen.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.ccs_test_2.features.valuteFavoriteScreen.databinding.RecordBookmarkItemBinding
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.model.RecordBookmark

class BookmarkViewHolder(private var binding: RecordBookmarkItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    val bookmark = binding.imageViewFavorite2

    fun bind(recordBookmark: RecordBookmark) {
        binding.apply {
            textViewDateFavorite.text = recordBookmark.date
            textViewNominalFavorite.text = recordBookmark.nominal.toString()
            textViewValueFavorite.text = recordBookmark.value
        }

    }
}





