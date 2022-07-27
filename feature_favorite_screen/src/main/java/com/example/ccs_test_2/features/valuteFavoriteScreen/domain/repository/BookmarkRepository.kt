package com.example.ccs_test_2.features.valuteFavoriteScreen.domain.repository

import androidx.lifecycle.LiveData
import com.example.ccs_test_2.common.database.data.modelDB.RecordDB
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.model.RecordBookmark

interface BookmarkRepository {
    suspend fun getBookmarks(): LiveData<List<RecordBookmark>>

    suspend fun deleteBookmark(recordBookmark: RecordBookmark)

    suspend fun deleteAllBookmarks()
}

