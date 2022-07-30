package com.example.ccs_test_2.features.valuteListScreen.data.dataSource.local

import com.example.ccs_test_2.common.database.data.modelDB.RecordDB


interface MainLocalDataSource {
    suspend fun addBookmark(recordDB: RecordDB)

    suspend fun deleteBookmark(recordDB: RecordDB)

}