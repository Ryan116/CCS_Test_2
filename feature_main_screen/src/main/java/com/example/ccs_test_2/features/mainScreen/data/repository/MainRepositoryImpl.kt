package com.example.ccs_test_2.features.mainScreen.data.repository

import com.example.ccs_test_2.features.mainScreen.data.dataSource.local.MainLocalDataSource
import com.example.ccs_test_2.features.mainScreen.data.dataSource.remote.MainRemoteDataSource
import com.example.ccs_test_2.features.mainScreen.data.mapper.MainMapper
import com.example.ccs_test_2.features.mainScreen.domain.model.MainCurrencyRateItem
import com.example.ccs_test_2.features.mainScreen.domain.repository.MainRepository

class MainRepositoryImpl(
    private val mainRemoteDataSource: MainRemoteDataSource,
    private val mainLocalDataSource: MainLocalDataSource,
    private val mainMapper: MainMapper
) : MainRepository {

    override suspend fun getCurrencyRate(dateFrom: String, dateBefore: String, currencyCode: String): List<MainCurrencyRateItem> {
        return mainRemoteDataSource.getCurrencyRateList(dateFrom, dateBefore, currencyCode).map {
            mainMapper.mapMainCurrencyRateItemRemoteToMainCurrencyRateItem(it)
        }
    }

    override suspend fun addBookmark(mainCurrencyRateItem: MainCurrencyRateItem) {
        mainLocalDataSource.addBookmark(mainMapper.mapMainCurrencyRateItemToCurrencyRateItemDB(mainCurrencyRateItem))
    }

    override suspend fun deleteBookmark(mainCurrencyRateItem: MainCurrencyRateItem) {
        mainLocalDataSource.deleteBookmark(mainMapper.mapMainCurrencyRateItemToCurrencyRateItemDB(mainCurrencyRateItem))
    }
}