package com.example.ccs_test_2.features.valuteListScreen.domain.usecase


import com.example.ccs_test_2.features.valuteListScreen.domain.model.RecordDomain
import com.example.ccs_test_2.features.valuteListScreen.domain.repository.MainRepository


class AddBookmarkUseCase(private val mainRepository: MainRepository) {
    suspend fun addBookmark(recordDomain: RecordDomain) {
        mainRepository.addBookmark(recordDomain)
    }
}