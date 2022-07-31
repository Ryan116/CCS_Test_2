package com.example.ccs_test_2.features.mainScreen.domain.repository

import com.example.ccs_test_2.features.mainScreen.domain.model.MainCurrencyRateItem

interface MainRepository {

    suspend fun getCurrencyRate(
        dateFrom: String,
        dateBefore: String,
        currencyCode: String
    ): List<MainCurrencyRateItem>

    suspend fun addBookmark(mainCurrencyRateItem: MainCurrencyRateItem)

    suspend fun deleteBookmark(mainCurrencyRateItem: MainCurrencyRateItem)
}