package com.example.ccs_test_2.features.valuteListScreen.data.dataSource.remote

import com.example.ccs_test_2.features.valuteListScreen.data.network.MainApi
import com.example.ccs_test_2.features.valuteListScreen.data.network.modelRemote.RecordRemote

class MainRemoteDataSourceImpl(
    private val mainApi: MainApi
    ) : MainRemoteDataSource {

    override suspend fun getValuteCurs(dateFrom: String, dateBefore: String, valuteCode: String): List<RecordRemote> {
        return mainApi.getValuteCurs(dateFrom, dateBefore,valuteCode).recordList
    }


}