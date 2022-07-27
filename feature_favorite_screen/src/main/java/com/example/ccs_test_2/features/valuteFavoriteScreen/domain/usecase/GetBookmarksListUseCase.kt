package com.example.ccs_test_2.features.valuteFavoriteScreen.domain.usecase

import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.model.RecordBookmark
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.repository.BookmarkRepository

class GetBookmarksListUseCase(private val bookmarkRepository: BookmarkRepository) {
    suspend fun getBookmarksList(): List<RecordBookmark> {
        return bookmarkRepository.getBookmarks()
    }
}

