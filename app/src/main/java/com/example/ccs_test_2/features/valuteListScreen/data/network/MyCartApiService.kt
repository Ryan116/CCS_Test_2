package com.example.ccs_test_2.features.valuteListScreen.data.network


import com.example.ccs_test_2.features.valuteListScreen.data.network.modelRemote.ValCursRemote
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://cbr.ru/scripts/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(SimpleXmlConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface ValuteApiInterface {
    @GET("XML_dynamic.asp")
    suspend fun getValuteCurs(
        @Query("date_req1") dateFrom: String,
        @Query("date_req2") dateBefore: String,
        @Query("VAL_NM_RQ") valuteCode: String = "R01235",
    ): ValCursRemote

}

object ValuteApi {
    val retrofitService: ValuteApiInterface by lazy {
        retrofit.create(ValuteApiInterface::class.java)
    }
}