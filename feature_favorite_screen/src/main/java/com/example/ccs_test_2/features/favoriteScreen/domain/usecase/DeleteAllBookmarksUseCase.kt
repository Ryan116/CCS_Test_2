package com.example.ccs_test_2.features.favoriteScreen.domain.usecase

import com.example.ccs_test_2.features.favoriteScreen.domain.repository.FavoriteRepository

class DeleteAllBookmarksUseCase(private val favoriteRepository: FavoriteRepository) {

    suspend fun deleteAllBookmarks() {
        favoriteRepository.deleteAllBookmarks()
    }
}