package com.example.ccs_test_2.features.mainScreen.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.ccs_test_2.features.mainScreen.databinding.CurrencyRateItemBinding
import com.example.ccs_test_2.features.mainScreen.domain.model.MainCurrencyRateItem

class MainViewHolder(private var binding: CurrencyRateItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    val bookmarkImageView = binding.imageViewFavorite

    fun bind(mainCurrencyRateItem: MainCurrencyRateItem) {
        binding.apply {
            textViewDate.text = mainCurrencyRateItem.date
            textViewNominal.text = mainCurrencyRateItem.nominal.toString()
            textViewValue.text = mainCurrencyRateItem.value

        }
    }
}



