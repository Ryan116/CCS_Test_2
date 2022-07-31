package com.example.ccs_test_2.features.mainScreen.presentation.adapter

import com.example.ccs_test_2.features.mainScreen.domain.model.MainCurrencyRateItem

interface BookmarkClickListener {
    fun addBookmark(mainCurrencyRateItemDomain: MainCurrencyRateItem)
    fun deleteBookmark(mainCurrencyRateItemDomain: MainCurrencyRateItem)
}