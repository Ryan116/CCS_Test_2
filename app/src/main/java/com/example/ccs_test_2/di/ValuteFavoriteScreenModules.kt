package com.example.ccs_test_2.di

import com.example.ccs_test_2.common.database.data.database.BookmarkDao
import com.example.ccs_test_2.common.database.data.database.BookmarkDatabase
import com.example.ccs_test_2.features.valuteFavoriteScreen.data.local.FavoriteLocalDataSource
import com.example.ccs_test_2.features.valuteFavoriteScreen.data.local.FavoriteLocalDataSourceImpl
import com.example.ccs_test_2.features.valuteFavoriteScreen.data.mapper.BookmarkScreenMapper
import com.example.ccs_test_2.features.valuteFavoriteScreen.data.repository.BookmarkRepositoryImpl
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.repository.BookmarkRepository
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.usecase.DeleteAllBookmarksUseCase
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.usecase.DeleteBookmarkUseCase
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.usecase.GetBookmarksListUseCase
import com.example.ccs_test_2.features.valuteFavoriteScreen.presentation.viewModel.BookmarksScreenViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val valuteFavoriteScreenDataModule = module {

    single<BookmarkRepository> {
        BookmarkRepositoryImpl(favoriteLocalDataSource = get(), bookmarkScreenMapper = get())
    }

    single<FavoriteLocalDataSource> {
        FavoriteLocalDataSourceImpl(bookmarkDao = get())
    }

    factory<BookmarkScreenMapper> {
        BookmarkScreenMapper()
    }

    single<BookmarkDao> {
        BookmarkDatabase.getDatabase(androidApplication()).bookmarkDao()
    }

}

val valuteFavoriteScreenDomainModule = module {

    factory<GetBookmarksListUseCase> {
        GetBookmarksListUseCase(bookmarkRepository = get())
    }

    factory<DeleteBookmarkUseCase> {
        DeleteBookmarkUseCase(bookmarkRepository = get())
    }

    factory<DeleteAllBookmarksUseCase> {
        DeleteAllBookmarksUseCase(bookmarkRepository = get())
    }
}

val valuteFavoriteScreenPresentationModule = module {

    viewModel {
        BookmarksScreenViewModel(
            get(),
            get(),
            get()
        )
    }
}