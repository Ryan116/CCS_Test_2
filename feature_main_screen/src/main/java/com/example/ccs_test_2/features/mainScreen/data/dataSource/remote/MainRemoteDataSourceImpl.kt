package com.example.ccs_test_2.features.mainScreen.data.dataSource.remote

import com.example.ccs_test_2.features.mainScreen.data.network.MainApi
import com.example.ccs_test_2.features.mainScreen.data.network.model.MainCurrencyRateItemRemote

class MainRemoteDataSourceImpl(
    private val mainApi: MainApi
) : MainRemoteDataSource {

    override suspend fun getCurrencyRateList(
        dateFrom: String,
        dateBefore: String,
        currencyCode: String
    ): List<MainCurrencyRateItemRemote> {
        return mainApi.getCurrencyRate(dateFrom, dateBefore, currencyCode).recordList
    }
}