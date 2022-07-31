package com.example.ccs_test_2.features.mainScreen.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.ccs_test_2.features.mainScreen.R
import com.example.ccs_test_2.features.mainScreen.databinding.CurrencyRateItemBinding
import com.example.ccs_test_2.features.mainScreen.domain.model.MainCurrencyRateItem

class MainAdapter(private val bookmarkClickListener: BookmarkClickListener) :
    ListAdapter<MainCurrencyRateItem, MainViewHolder>(MainDiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainViewHolder {
        return MainViewHolder(
            CurrencyRateItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        val listItem = getItem(position)

        holder.bind(listItem)

        holder.bookmarkImageView.setOnClickListener {
            if (listItem.pressed) {
                holder.bookmarkImageView.setImageResource(R.drawable.ic_add_to_favorite_empty_2)
                bookmarkClickListener.deleteBookmark(listItem)
                listItem.pressed = false
            } else {
                holder.bookmarkImageView.setImageResource(R.drawable.ic_add_to_favorite_full_2)
                bookmarkClickListener.addBookmark(listItem)
                listItem.pressed = true
            }
        }
    }
}



