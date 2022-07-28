package com.example.ccs_test_2.features.valuteFavoriteScreen.domain.repository

import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.model.RecordBookmark
import kotlinx.coroutines.flow.Flow

interface BookmarkRepository {
    suspend fun getBookmarks(): Flow<List<RecordBookmark>>

    suspend fun deleteBookmark(recordBookmark: RecordBookmark)

    suspend fun deleteAllBookmarks()
}

