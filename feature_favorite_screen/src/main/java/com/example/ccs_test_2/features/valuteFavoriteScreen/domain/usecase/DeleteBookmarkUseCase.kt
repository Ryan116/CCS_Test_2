package com.example.ccs_test_2.features.valuteFavoriteScreen.domain.usecase


import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.model.RecordBookmark
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.repository.BookmarkRepository

class DeleteBookmarkUseCase(private val bookmarkRepository: BookmarkRepository) {
    suspend fun deleteBookmark(recordBookmark: RecordBookmark) {
        bookmarkRepository.deleteBookmark(recordBookmark)
    }
}
