package com.example.ccs_test_2.features.valuteFavoriteScreen.domain.repository

import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.model.FavoriteCurrencyRateItem
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {

    suspend fun getBookmarks(): Flow<List<FavoriteCurrencyRateItem>>

    suspend fun deleteBookmark(favoriteCurrencyRateItem: FavoriteCurrencyRateItem)

    suspend fun deleteAllBookmarks()
}

