package com.example.ccs_test_2.features.valuteFavoriteScreen.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.ccs_test_2.features.valuteFavoriteScreen.databinding.RecordItemBinding
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.model.RecordBookmark

class BookmarkViewHolder(private var binding: RecordItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    val bookmark = binding.imageViewFavorite

    fun bind(recordBookmark: RecordBookmark) {
        binding.apply {
            textViewDate.text = recordBookmark.date
            textViewNominal.text = recordBookmark.nominal.toString()
            textViewValue.text = recordBookmark.value
        }

    }
}





