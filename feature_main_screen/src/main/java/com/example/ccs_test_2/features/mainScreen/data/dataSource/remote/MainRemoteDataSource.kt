package com.example.ccs_test_2.features.mainScreen.data.dataSource.remote

import com.example.ccs_test_2.features.mainScreen.data.network.model.MainCurrencyRateItemRemote

interface MainRemoteDataSource {

    suspend fun getCurrencyRateList(
        dateFrom: String,
        dateBefore: String,
        currencyCode: String
    ): List<MainCurrencyRateItemRemote>
}