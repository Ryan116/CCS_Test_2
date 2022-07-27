package com.example.ccs_test_2.features.valuteFavoriteScreen.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.model.RecordBookmark

class BookmarkDiffCallback:DiffUtil.ItemCallback<RecordBookmark>() {
    override fun areItemsTheSame(oldItem: RecordBookmark, newItem: RecordBookmark): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RecordBookmark, newItem: RecordBookmark): Boolean {
        return oldItem == newItem
    }
}