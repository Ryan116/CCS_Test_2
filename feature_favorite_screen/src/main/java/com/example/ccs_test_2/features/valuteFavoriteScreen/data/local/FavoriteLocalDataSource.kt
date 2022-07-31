package com.example.ccs_test_2.features.valuteFavoriteScreen.data.local

import com.example.ccs_test_2.common.database.data.modelDB.CurrencyRateItemDB
import kotlinx.coroutines.flow.Flow


interface FavoriteLocalDataSource {
    suspend fun getBookmarks(): Flow<List<CurrencyRateItemDB>>

    suspend fun deleteBookmark(currencyRateItemDB: CurrencyRateItemDB)

    suspend fun deleteAllBookmarks()

}