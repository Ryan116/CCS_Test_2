package com.example.ccs_test_2.features.valuteFavoriteScreen.domain.usecase

import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.model.FavoriteCurrencyRateItem
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.repository.FavoriteRepository

class DeleteBookmarkUseCase(private val favoriteRepository: FavoriteRepository) {

    suspend fun deleteBookmark(favoriteCurrencyRateItem: FavoriteCurrencyRateItem) {
        favoriteRepository.deleteBookmark(favoriteCurrencyRateItem)
    }
}
