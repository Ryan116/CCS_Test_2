package com.example.ccs_test_2.di

import com.example.ccs_test_2.features.valuteListScreen.domain.repository.ValuteRepository
import com.example.ccs_test_2.features.valuteListScreen.domain.usecase.AddBookmarkUseCase
import com.example.ccs_test_2.features.valuteListScreen.domain.usecase.DeleteBookmarkUseCase
import com.example.ccs_test_2.features.valuteListScreen.domain.usecase.GetValuteCursUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class ValuteListScreenDomainModule {

    @Provides
    fun provideGetValuteCursUseCase(valuteRepository: ValuteRepository): GetValuteCursUseCase {
        return GetValuteCursUseCase(
            valuteRepository = valuteRepository
        )
    }

    @Provides
    fun provideAddBookmarkUseCase(valuteRepository: ValuteRepository): AddBookmarkUseCase {
        return AddBookmarkUseCase(
            valuteRepository = valuteRepository
        )
    }

    @Provides
    fun provideDeleteBookmarkUseCase(valuteRepository: ValuteRepository): DeleteBookmarkUseCase {
        return DeleteBookmarkUseCase(
            valuteRepository = valuteRepository
        )
    }
}