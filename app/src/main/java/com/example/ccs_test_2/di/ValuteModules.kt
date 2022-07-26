package com.example.ccs_test_2.di


import com.example.ccs_test_2.features.valuteListScreen.data.dataSource.remote.ValuteRemoteDataSource
import com.example.ccs_test_2.features.valuteListScreen.data.dataSource.remote.ValuteRemoteDataSourceImpl
import com.example.ccs_test_2.features.valuteListScreen.data.mapper.ValuteMapper
import com.example.ccs_test_2.features.valuteListScreen.data.network.ValuteApi
import com.example.ccs_test_2.features.valuteListScreen.data.network.ValuteApiInterface
import com.example.ccs_test_2.features.valuteListScreen.data.repository.ValuteRepositoryImpl
import com.example.ccs_test_2.features.valuteListScreen.domain.repository.ValuteRepository
import com.example.ccs_test_2.features.valuteListScreen.domain.usecase.GetValuteCursUseCase
import com.example.ccs_test_2.features.valuteListScreen.presentation.viewModel.ValuteListScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {
    single<ValuteRepository> {
        ValuteRepositoryImpl(
            valuteRemoteDataSource = get(),
            valuteMapper = get()
        )
    }

    single<ValuteRemoteDataSource> {
        ValuteRemoteDataSourceImpl(
            valuteApiInterface = get()
        )
    }

    single<ValuteApiInterface> {
        ValuteApi.retrofitService
    }

    factory<ValuteMapper> {
        ValuteMapper()
    }
}

val domainModule = module {
    factory<GetValuteCursUseCase> {
        GetValuteCursUseCase(
            valuteRepository = get()
        )
    }
}

val presentationModule = module {
    viewModel {
        ValuteListScreenViewModel(
            getValuteCursUseCase = get()
        )
    }
}