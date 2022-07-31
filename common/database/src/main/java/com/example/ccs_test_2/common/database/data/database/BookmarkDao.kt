package com.example.ccs_test_2.common.database.data.database

import androidx.room.*
import com.example.ccs_test_2.common.database.data.model.CurrencyRateItemDB
import kotlinx.coroutines.flow.Flow

@Dao
interface BookmarkDao {

    @Query("SELECT * FROM currency_rate_table ORDER BY id")
    fun getBookmarks(): Flow<List<CurrencyRateItemDB>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addBookmark(currencyRateItemDB: CurrencyRateItemDB)

    @Delete
    suspend fun deleteBookmark(currencyRateItemDB: CurrencyRateItemDB)

    @Query("DELETE FROM currency_rate_table")
    suspend fun deleteAllBookmarks()
}