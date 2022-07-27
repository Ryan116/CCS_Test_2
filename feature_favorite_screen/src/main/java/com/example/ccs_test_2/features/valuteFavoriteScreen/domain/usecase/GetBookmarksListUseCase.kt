package com.example.ccs_test_2.features.valuteFavoriteScreen.domain.usecase

import androidx.lifecycle.LiveData
import com.example.ccs_test_2.common.database.data.modelDB.RecordDB
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.model.RecordBookmark
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.repository.BookmarkRepository

class GetBookmarksListUseCase(private val bookmarkRepository: BookmarkRepository) {
    suspend fun getBookmarksList(): LiveData<List<RecordBookmark>> {
        return bookmarkRepository.getBookmarks()
    }
}

