package com.example.ccs_test_2.features.mainScreen.data.dataSource.local

import com.example.ccs_test_2.common.database.data.model.CurrencyRateItemDB

interface MainLocalDataSource {

    suspend fun addBookmark(currencyRateItemDB: CurrencyRateItemDB)

    suspend fun deleteBookmark(currencyRateItemDB: CurrencyRateItemDB)
}