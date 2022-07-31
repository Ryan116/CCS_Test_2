package com.example.ccs_test_2.features.mainScreen.data.dataSource.local

import com.example.ccs_test_2.common.database.data.database.BookmarkDao
import com.example.ccs_test_2.common.database.data.modelDB.CurrencyRateItemDB

class MainLocalDataSourceImpl(
    private val bookmarkDao: BookmarkDao
) : MainLocalDataSource {

    override suspend fun addBookmark(currencyRateItemDB: CurrencyRateItemDB) {
        bookmarkDao.addBookmark(currencyRateItemDB)
    }

    override suspend fun deleteBookmark(currencyRateItemDB: CurrencyRateItemDB) {
        bookmarkDao.deleteBookmark(currencyRateItemDB)
    }
}