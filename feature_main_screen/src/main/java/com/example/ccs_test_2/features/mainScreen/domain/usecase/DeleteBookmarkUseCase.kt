package com.example.ccs_test_2.features.mainScreen.domain.usecase

import com.example.ccs_test_2.features.mainScreen.domain.model.MainCurrencyRateItem
import com.example.ccs_test_2.features.mainScreen.domain.repository.MainRepository

class DeleteBookmarkUseCase(private val mainRepository: MainRepository) {

    suspend fun deleteBookmark(mainCurrencyRateItem: MainCurrencyRateItem) {
        mainRepository.deleteBookmark(mainCurrencyRateItem)
    }
}
