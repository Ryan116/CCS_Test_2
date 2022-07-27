package com.example.ccs_test_2.features.valuteListScreen.data.dataSource.local

import com.example.ccs_test_2.common.database.data.database.BookmarkDao
import com.example.ccs_test_2.common.database.data.modelDB.RecordDB


class ValuteLocalDataSourceImpl(
    private val bookmarkDao: BookmarkDao
) : ValuteLocalDataSource {

    override suspend fun addBookmark(recordDB: RecordDB) {
        bookmarkDao.addBookmark(recordDB)
    }

    override suspend fun deleteBookmark(recordDB: RecordDB) {
        bookmarkDao.deleteBookmark(recordDB)
    }


}