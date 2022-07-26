package com.example.ccs_test_2.features.favoriteScreen.domain.usecase

import com.example.ccs_test_2.features.favoriteScreen.domain.model.FavoriteCurrencyRateItem
import com.example.ccs_test_2.features.favoriteScreen.domain.repository.FavoriteRepository

class DeleteBookmarkUseCase(private val favoriteRepository: FavoriteRepository) {

    suspend fun deleteBookmark(favoriteCurrencyRateItem: FavoriteCurrencyRateItem) {
        favoriteRepository.deleteBookmark(favoriteCurrencyRateItem)
    }
}
