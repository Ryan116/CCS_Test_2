package com.example.ccs_test_2.features.valuteListScreen.domain.usecase

import androidx.lifecycle.LiveData
import com.example.ccs_test_2.features.valuteListScreen.domain.model.RecordDomain
import com.example.ccs_test_2.features.valuteListScreen.domain.repository.ValuteRepository

class GetValuteCursUseCase(private val valuteRepository: ValuteRepository) {
    suspend fun getValuteCurs(
        dateFrom: String,
        dateBefore: String
    ): LiveData<List<RecordDomain>> {
        return valuteRepository.getValuteCurs(dateFrom, dateBefore)
    }
}