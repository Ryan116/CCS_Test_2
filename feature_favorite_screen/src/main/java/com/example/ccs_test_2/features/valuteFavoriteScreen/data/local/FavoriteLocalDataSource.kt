package com.example.ccs_test_2.features.valuteFavoriteScreen.data.local

import androidx.lifecycle.LiveData
import com.example.ccs_test_2.common.database.data.modelDB.RecordDB
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow


interface FavoriteLocalDataSource {
    suspend fun getBookmarks(): Flow<List<RecordDB>>

    suspend fun deleteBookmark(recordDB: RecordDB)

    suspend fun deleteAllBookmarks()

}