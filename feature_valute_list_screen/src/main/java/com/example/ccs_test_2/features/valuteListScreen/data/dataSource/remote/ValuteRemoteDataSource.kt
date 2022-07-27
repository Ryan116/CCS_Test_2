package com.example.ccs_test_2.features.valuteListScreen.data.dataSource.remote

import com.example.ccs_test_2.features.valuteListScreen.data.network.modelRemote.RecordRemote


interface ValuteRemoteDataSource {

    suspend fun getValuteCurs(dateFrom: String, dateBefore: String, valuteCode: String): List<RecordRemote>?
}