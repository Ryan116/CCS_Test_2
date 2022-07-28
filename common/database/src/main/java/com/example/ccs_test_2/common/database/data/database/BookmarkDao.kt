package com.example.ccs_test_2.common.database.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.ccs_test_2.common.database.data.modelDB.RecordDB
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

@Dao
interface BookmarkDao {
    @Query("SELECT * FROM currency_table ORDER BY id")
    fun getBookmarks(): Flow<List<RecordDB>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addBookmark(recordDB: RecordDB)

    @Delete
    suspend fun deleteBookmark(recordDB: RecordDB)

    @Query("DELETE FROM currency_table")
    suspend fun deleteAllBookmarks()

}