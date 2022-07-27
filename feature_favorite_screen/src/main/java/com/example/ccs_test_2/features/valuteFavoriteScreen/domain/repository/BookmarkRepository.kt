package com.example.ccs_test_2.features.valuteFavoriteScreen.domain.repository

import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.model.RecordBookmark

interface BookmarkRepository {
    suspend fun getBookmarks(): List<RecordBookmark>

    suspend fun deleteBookmark(recordBookmark: RecordBookmark)

    suspend fun deleteAllBookmarks()
}

