package com.example.ccs_test_2.features.mainScreen.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.ccs_test_2.features.mainScreen.domain.model.MainCurrencyRateItem

class MainDiffCallback : DiffUtil.ItemCallback<MainCurrencyRateItem>() {

    override fun areItemsTheSame(
        oldItem: MainCurrencyRateItem,
        newItem: MainCurrencyRateItem
    ): Boolean {
        return oldItem.value == newItem.value
    }

    override fun areContentsTheSame(
        oldItem: MainCurrencyRateItem,
        newItem: MainCurrencyRateItem
    ): Boolean {
        return oldItem == newItem
    }
}