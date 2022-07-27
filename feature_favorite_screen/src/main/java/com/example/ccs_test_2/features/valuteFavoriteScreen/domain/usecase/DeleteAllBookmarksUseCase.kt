package com.example.ccs_test_2.features.valuteFavoriteScreen.domain.usecase


import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.repository.BookmarkRepository

class DeleteAllBookmarksUseCase(private val bookmarkRepository: BookmarkRepository) {
    suspend fun deleteAllBookmarks() {
        bookmarkRepository.deleteAllBookmarks()
    }
}