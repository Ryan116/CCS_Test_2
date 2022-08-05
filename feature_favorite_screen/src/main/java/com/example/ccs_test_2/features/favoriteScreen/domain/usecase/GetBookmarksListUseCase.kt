package com.example.ccs_test_2.features.favoriteScreen.domain.usecase

import com.example.ccs_test_2.features.favoriteScreen.domain.model.FavoriteCurrencyRateItem
import com.example.ccs_test_2.features.favoriteScreen.domain.repository.FavoriteRepository
import kotlinx.coroutines.flow.Flow

class GetBookmarksListUseCase(private val favoriteRepository: FavoriteRepository) {

    suspend fun getBookmarksList(): Flow<List<FavoriteCurrencyRateItem>> =
        favoriteRepository.getBookmarks()
}

