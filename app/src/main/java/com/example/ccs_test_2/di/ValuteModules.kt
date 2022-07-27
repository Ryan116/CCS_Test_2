package com.example.ccs_test_2.di


import com.example.ccs_test_2.common.database.data.database.BookmarkDao
import com.example.ccs_test_2.common.database.data.database.BookmarkDatabase
import com.example.ccs_test_2.features.valuteListScreen.data.dataSource.local.ValuteLocalDataSource
import com.example.ccs_test_2.features.valuteListScreen.data.dataSource.local.ValuteLocalDataSourceImpl
import com.example.ccs_test_2.features.valuteListScreen.data.dataSource.remote.ValuteRemoteDataSource
import com.example.ccs_test_2.features.valuteListScreen.data.dataSource.remote.ValuteRemoteDataSourceImpl
import com.example.ccs_test_2.features.valuteListScreen.data.mapper.ValuteMapper
import com.example.ccs_test_2.features.valuteListScreen.data.network.ValuteApi
import com.example.ccs_test_2.features.valuteListScreen.data.network.ValuteApiInterface
import com.example.ccs_test_2.features.valuteListScreen.data.repository.ValuteRepositoryImpl
import com.example.ccs_test_2.features.valuteListScreen.domain.repository.ValuteRepository
import com.example.ccs_test_2.features.valuteListScreen.domain.usecase.AddBookmarkUseCase
import com.example.ccs_test_2.features.valuteListScreen.domain.usecase.DeleteBookmarkUseCase
import com.example.ccs_test_2.features.valuteListScreen.domain.usecase.GetValuteCursUseCase
import com.example.ccs_test_2.features.valuteListScreen.presentation.viewModel.ValuteListScreenViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val valuteListScreenDataModule = module {
    single<ValuteRepository> {
        ValuteRepositoryImpl(
            valuteRemoteDataSource = get(),
            valuteMapper = get(),
            valuteLocalDataSource = get()
        )
    }

    single<ValuteRemoteDataSource> {
        ValuteRemoteDataSourceImpl(
            valuteApiInterface = get()
        )
    }

    single<ValuteLocalDataSource> {
        ValuteLocalDataSourceImpl(
            bookmarkDao = get()
        )
    }

    single<BookmarkDao> {
        BookmarkDatabase.getDatabase(androidApplication()).bookmarkDao()
    }

    single<ValuteApiInterface> {
        ValuteApi.retrofitService
    }

    factory<ValuteMapper> {
        ValuteMapper()
    }
}

val valuteListDomainModule = module {

    factory<GetValuteCursUseCase> {
        GetValuteCursUseCase(
            valuteRepository = get()
        )
    }

    factory<AddBookmarkUseCase> {
        AddBookmarkUseCase(
            valuteRepository = get()
        )
    }

    factory<DeleteBookmarkUseCase> {
        DeleteBookmarkUseCase(
            valuteRepository = get()
        )
    }
}

val valuteListScreenPresentationModule = module {
    viewModel {
        ValuteListScreenViewModel(
            getValuteCursUseCase = get(),
            addBookmarkUseCase = get(),
            deleteBookmarkUseCase = get()
        )
    }
}