package com.example.ccs_test_2.features.valuteListScreen.domain.usecase

import com.example.ccs_test_2.features.valuteListScreen.domain.model.RecordDomain
import com.example.ccs_test_2.features.valuteListScreen.domain.repository.MainRepository

class GetCurrencyRateUseCase(private val mainRepository: MainRepository) {
    suspend fun getValuteCurs(
        dateFrom: String,
        dateBefore: String,
        valuteCode: String
    ): List<RecordDomain> {
        return mainRepository.getValuteCurs(dateFrom, dateBefore, valuteCode)
    }
}