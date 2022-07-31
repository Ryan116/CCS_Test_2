package com.example.ccs_test_2.features.valuteFavoriteScreen.domain.usecase

import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.model.FavoriteCurrencyRateItem
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.repository.FavoriteRepository
import kotlinx.coroutines.flow.Flow

class GetBookmarksListUseCase(private val favoriteRepository: FavoriteRepository) {

    suspend fun getBookmarksList(): Flow<List<FavoriteCurrencyRateItem>> {
        return favoriteRepository.getBookmarks()
    }
}

