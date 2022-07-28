package com.example.ccs_test_2.features.valuteFavoriteScreen.domain.usecase

import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.model.RecordBookmark
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.repository.BookmarkRepository
import kotlinx.coroutines.flow.Flow

class GetBookmarksListUseCase(private val bookmarkRepository: BookmarkRepository) {
    suspend fun getBookmarksList(): Flow<List<RecordBookmark>> {
        return bookmarkRepository.getBookmarks()
    }
}

