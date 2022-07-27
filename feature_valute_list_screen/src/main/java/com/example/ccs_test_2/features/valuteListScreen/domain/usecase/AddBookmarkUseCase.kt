package com.example.ccs_test_2.features.valuteListScreen.domain.usecase


import com.example.ccs_test_2.features.valuteListScreen.domain.model.RecordDomain
import com.example.ccs_test_2.features.valuteListScreen.domain.repository.ValuteRepository


class AddBookmarkUseCase(private val valuteRepository: ValuteRepository) {
    suspend fun addBookmark(recordDomain: RecordDomain) {
        valuteRepository.addBookmark(recordDomain)
    }
}