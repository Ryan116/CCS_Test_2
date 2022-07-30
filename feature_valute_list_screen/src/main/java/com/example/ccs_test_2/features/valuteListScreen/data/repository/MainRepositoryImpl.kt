package com.example.ccs_test_2.features.valuteListScreen.data.repository

import com.example.ccs_test_2.features.valuteListScreen.data.dataSource.local.MainLocalDataSource
import com.example.ccs_test_2.features.valuteListScreen.data.dataSource.remote.MainRemoteDataSource
import com.example.ccs_test_2.features.valuteListScreen.data.mapper.MainMapper
import com.example.ccs_test_2.features.valuteListScreen.domain.model.RecordDomain
import com.example.ccs_test_2.features.valuteListScreen.domain.repository.MainRepository

class MainRepositoryImpl(
    private val mainRemoteDataSource: MainRemoteDataSource,
    private val mainLocalDataSource: MainLocalDataSource,
    private val mainMapper: MainMapper
) : MainRepository {
    override suspend fun getValuteCurs(dateFrom: String, dateBefore: String, valuteCode: String): List<RecordDomain> {
        var list: List<RecordDomain> = mutableListOf()
        mainRemoteDataSource.getValuteCurs(dateFrom, dateBefore, valuteCode)?.let {
            list = mainMapper.mapListRecordRemoteToListRecordDomain(it)
        }
        return list
    }

    override suspend fun addBookmark(recordDomain: RecordDomain) {
        mainLocalDataSource.addBookmark(mainMapper.mapRecordDomainToRecordDB(recordDomain))
    }

    override suspend fun deleteBookmark(recordDomain: RecordDomain) {
        mainLocalDataSource.deleteBookmark(mainMapper.mapRecordDomainToRecordDB(recordDomain))
    }
}