package com.example.ccs_test_2.features.favoriteScreen.data.local

import com.example.ccs_test_2.common.database.data.database.BookmarkDao
import com.example.ccs_test_2.common.database.data.model.CurrencyRateItemDB
import kotlinx.coroutines.flow.Flow

class FavoriteLocalDataSourceImpl(private val bookmarkDao: BookmarkDao) : FavoriteLocalDataSource {

    override suspend fun getBookmarksList(): Flow<List<CurrencyRateItemDB>> =
        bookmarkDao.getBookmarks()


    override suspend fun deleteBookmark(currencyRateItemDB: CurrencyRateItemDB) {
        bookmarkDao.deleteBookmark(currencyRateItemDB)
    }

    override suspend fun deleteAllBookmarks() {
        bookmarkDao.deleteAllBookmarks()
    }
}