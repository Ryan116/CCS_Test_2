package com.example.ccs_test_2.features.valuteFavoriteScreen.domain.usecase


import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.repository.FavoriteRepository

class DeleteAllBookmarksUseCase(private val favoriteRepository: FavoriteRepository) {
    suspend fun deleteAllBookmarks() {
        favoriteRepository.deleteAllBookmarks()
    }
}