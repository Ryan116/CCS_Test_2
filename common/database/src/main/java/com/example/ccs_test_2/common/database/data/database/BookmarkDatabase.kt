package com.example.ccs_test_2.common.database.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ccs_test_2.common.database.data.model.CurrencyRateItemDB

@Database(entities = [CurrencyRateItemDB::class], version = 1, exportSchema = false)
abstract class BookmarkDatabase : RoomDatabase() {

    abstract fun getBookmarkDao(): BookmarkDao
}