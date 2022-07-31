package com.example.ccs_test_2.features.valuteListScreen.data.dataSource.local

import com.example.ccs_test_2.common.database.data.modelDB.CurrencyRateItemDB


interface MainLocalDataSource {
    suspend fun addBookmark(currencyRateItemDB: CurrencyRateItemDB)

    suspend fun deleteBookmark(currencyRateItemDB: CurrencyRateItemDB)

}