package com.example.ccs_test_2.features.valuteFavoriteScreen.data.local


import android.util.Log
import androidx.lifecycle.LiveData
import com.example.ccs_test_2.common.database.data.database.BookmarkDao
import com.example.ccs_test_2.common.database.data.modelDB.RecordDB


class FavoriteLocalDataSourceImpl(private val bookmarkDao: BookmarkDao) : FavoriteLocalDataSource {
    override suspend fun getBookmarks(): LiveData<List<RecordDB>> {
        return bookmarkDao.getBookmarks()
    }

    override suspend fun deleteBookmark(recordDB: RecordDB) {
        bookmarkDao.deleteBookmark(recordDB)
    }

    override suspend fun deleteAllBookmarks() {
        bookmarkDao.deleteAllBookmarks()
    }


}