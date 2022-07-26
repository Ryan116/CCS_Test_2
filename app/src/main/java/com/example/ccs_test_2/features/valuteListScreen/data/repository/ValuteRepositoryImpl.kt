package com.example.ccs_test_2.features.valuteListScreen.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ccs_test_2.features.valuteListScreen.data.dataSource.remote.ValuteRemoteDataSource
import com.example.ccs_test_2.features.valuteListScreen.data.mapper.ValuteMapper
import com.example.ccs_test_2.features.valuteListScreen.domain.model.RecordDomain
import com.example.ccs_test_2.features.valuteListScreen.domain.repository.ValuteRepository

class ValuteRepositoryImpl(
    private val valuteRemoteDataSource: ValuteRemoteDataSource,
    private val valuteMapper: ValuteMapper
) : ValuteRepository {
    override suspend fun getValuteCurs(dateFrom: String, dateBefore: String): LiveData<List<RecordDomain>> {
        var listLiveDataRecord = MutableLiveData<List<RecordDomain>>()
        valuteRemoteDataSource.getValuteCurs(dateFrom, dateBefore)?.let {
            listLiveDataRecord.value = valuteMapper.mapListRecordDBToListRecord(it)
        }
        return listLiveDataRecord
    }
}