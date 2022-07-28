package com.example.ccs_test_2.features.valuteListScreen.domain.usecase

import com.example.ccs_test_2.features.valuteListScreen.domain.model.RecordDomain
import com.example.ccs_test_2.features.valuteListScreen.domain.repository.ValuteRepository

class GetValuteCursUseCase(private val valuteRepository: ValuteRepository) {
    suspend fun getValuteCurs(
        dateFrom: String,
        dateBefore: String,
        valuteCode: String
    ): List<RecordDomain> {
        return valuteRepository.getValuteCurs(dateFrom, dateBefore, valuteCode)
    }
}