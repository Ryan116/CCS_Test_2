package com.example.ccs_test_2.di

import com.example.ccs_test_2.features.valuteListScreen.domain.repository.MainRepository
import com.example.ccs_test_2.features.valuteListScreen.domain.usecase.AddBookmarkUseCase
import com.example.ccs_test_2.features.valuteListScreen.domain.usecase.DeleteBookmarkUseCase
import com.example.ccs_test_2.features.valuteListScreen.domain.usecase.GetCurrencyRateUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class MainDomainModule {

    @Provides
    fun provideGetCurrencyRateUseCase(mainRepository: MainRepository): GetCurrencyRateUseCase {
        return GetCurrencyRateUseCase(
            mainRepository = mainRepository
        )
    }

    @Provides
    fun provideAddBookmarkUseCase(mainRepository: MainRepository): AddBookmarkUseCase {
        return AddBookmarkUseCase(
            mainRepository = mainRepository
        )
    }

    @Provides
    fun provideDeleteBookmarkUseCase(mainRepository: MainRepository): DeleteBookmarkUseCase {
        return DeleteBookmarkUseCase(
            mainRepository = mainRepository
        )
    }
}