package com.example.ccs_test_2.features.valuteFavoriteScreen.domain.usecase


import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.model.RecordBookmark
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.repository.FavoriteRepository

class DeleteBookmarkUseCase(private val favoriteRepository: FavoriteRepository) {
    suspend fun deleteBookmark(recordBookmark: RecordBookmark) {
        favoriteRepository.deleteBookmark(recordBookmark)
    }
}
