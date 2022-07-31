package com.example.ccs_test_2.features.mainScreen.domain.usecase

import com.example.ccs_test_2.features.mainScreen.domain.model.MainCurrencyRateItem
import com.example.ccs_test_2.features.mainScreen.domain.repository.MainRepository

class AddBookmarkUseCase(private val mainRepository: MainRepository) {

    suspend fun addBookmark(mainCurrencyRateItem: MainCurrencyRateItem) {
        mainRepository.addBookmark(mainCurrencyRateItem)
    }
}