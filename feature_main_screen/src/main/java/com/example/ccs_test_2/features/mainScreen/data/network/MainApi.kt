package com.example.ccs_test_2.features.mainScreen.data.network

import com.example.ccs_test_2.common.constants.Constants
import com.example.ccs_test_2.common.constants.Constants.MAIN_API_QUERY_DATE_REQ_1
import com.example.ccs_test_2.common.constants.Constants.MAIN_API_QUERY_DATE_REQ_2
import com.example.ccs_test_2.common.constants.Constants.MAIN_API_QUERY_VAL_NM_RQ
import com.example.ccs_test_2.features.mainScreen.data.network.model.MainCurrencyRateFullInfoRemote
import retrofit2.http.GET
import retrofit2.http.Query

interface MainApi {
    @GET(Constants.GET_URL)
    suspend fun getCurrencyRate(
        @Query(MAIN_API_QUERY_DATE_REQ_1) dateFrom: String,
        @Query(MAIN_API_QUERY_DATE_REQ_2) dateBefore: String,
        @Query(MAIN_API_QUERY_VAL_NM_RQ) currencyCode: String,
    ): MainCurrencyRateFullInfoRemote
}