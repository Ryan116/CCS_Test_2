package com.example.ccs_test_2.features.favoriteScreen.data.local

import com.example.ccs_test_2.common.database.data.model.CurrencyRateItemDB
import kotlinx.coroutines.flow.Flow

interface FavoriteLocalDataSource {

    suspend fun getBookmarksList(): Flow<List<CurrencyRateItemDB>>

    suspend fun deleteBookmark(currencyRateItemDB: CurrencyRateItemDB)

    suspend fun deleteAllBookmarks()
}