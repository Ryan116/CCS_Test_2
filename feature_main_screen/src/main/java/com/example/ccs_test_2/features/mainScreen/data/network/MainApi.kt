package com.example.ccs_test_2.features.mainScreen.data.network

import com.example.ccs_test_2.common.constants.Constants
import com.example.ccs_test_2.features.mainScreen.data.network.model.MainCurrencyRateFullInfoRemote
import retrofit2.http.GET
import retrofit2.http.Query

interface MainApi {
    @GET(Constants.GET_URL)
    suspend fun getCurrencyRate(
        @Query("date_req1") dateFrom: String,
        @Query("date_req2") dateBefore: String,
        @Query("VAL_NM_RQ") currencyCode: String,
    ): MainCurrencyRateFullInfoRemote
}