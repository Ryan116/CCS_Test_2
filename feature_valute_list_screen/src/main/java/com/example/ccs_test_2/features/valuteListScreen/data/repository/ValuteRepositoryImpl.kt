package com.example.ccs_test_2.features.valuteListScreen.data.repository

import com.example.ccs_test_2.features.valuteListScreen.data.dataSource.local.ValuteLocalDataSource
import com.example.ccs_test_2.features.valuteListScreen.data.dataSource.remote.ValuteRemoteDataSource
import com.example.ccs_test_2.features.valuteListScreen.data.mapper.ValuteMapper
import com.example.ccs_test_2.features.valuteListScreen.domain.model.RecordDomain
import com.example.ccs_test_2.features.valuteListScreen.domain.repository.ValuteRepository

class ValuteRepositoryImpl(
    private val valuteRemoteDataSource: ValuteRemoteDataSource,
    private val valuteLocalDataSource: ValuteLocalDataSource,
    private val valuteMapper: ValuteMapper
) : ValuteRepository {
    override suspend fun getValuteCurs(dateFrom: String, dateBefore: String, valuteCode: String): List<RecordDomain> {
        var list: List<RecordDomain> = mutableListOf()
        valuteRemoteDataSource.getValuteCurs(dateFrom, dateBefore, valuteCode)?.let {
            list = valuteMapper.mapListRecordRemoteToListRecordDomain(it)
        }
        return list
    }

    override suspend fun addBookmark(recordDomain: RecordDomain) {
        valuteLocalDataSource.addBookmark(valuteMapper.mapRecordDomainToRecordDB(recordDomain))
    }

    override suspend fun deleteBookmark(recordDomain: RecordDomain) {
        valuteLocalDataSource.deleteBookmark(valuteMapper.mapRecordDomainToRecordDB(recordDomain))
    }
}