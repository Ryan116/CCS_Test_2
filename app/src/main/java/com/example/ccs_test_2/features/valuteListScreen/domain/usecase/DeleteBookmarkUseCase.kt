package com.example.ccs_test_2.features.valuteListScreen.domain.usecase


import com.example.ccs_test_2.features.valuteListScreen.domain.model.RecordDomain
import com.example.ccs_test_2.features.valuteListScreen.domain.repository.ValuteRepository

class DeleteBookmarkUseCase(private val valuteRepository: ValuteRepository) {
    suspend fun deleteBookmark(recordDomain: RecordDomain) {
        valuteRepository.deleteBookmark(recordDomain)
    }
}
