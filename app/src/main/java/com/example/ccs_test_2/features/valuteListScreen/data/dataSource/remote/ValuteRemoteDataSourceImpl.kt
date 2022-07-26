package com.example.ccs_test_2.features.valuteListScreen.data.dataSource.remote

import com.example.ccs_test_2.features.valuteListScreen.data.network.ValuteApiInterface
import com.example.ccs_test_2.features.valuteListScreen.data.network.modelRemote.RecordRemote

class ValuteRemoteDataSourceImpl(
    private val valuteApiInterface: ValuteApiInterface
    ) : ValuteRemoteDataSource {

    override suspend fun getValuteCurs(dateFrom: String, dateBefore: String): List<RecordRemote>? {
        return valuteApiInterface.getValuteCurs(dateFrom, dateBefore).recordList
    }


}