package com.example.ccs_test_2.features.mainScreen.domain.usecase

import com.example.ccs_test_2.features.mainScreen.domain.model.MainCurrencyRateItem
import com.example.ccs_test_2.features.mainScreen.domain.repository.MainRepository

class GetCurrencyRateUseCase(private val mainRepository: MainRepository) {

    suspend fun getCurrencyRate(
        dateFrom: String,
        dateBefore: String,
        currencyCode: String
    ): List<MainCurrencyRateItem> =
        mainRepository.getCurrencyRate(dateFrom, dateBefore, currencyCode)
}