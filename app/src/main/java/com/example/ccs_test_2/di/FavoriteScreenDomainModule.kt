package com.example.ccs_test_2.di

import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.repository.BookmarkRepository
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.usecase.DeleteAllBookmarksUseCase
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.usecase.DeleteBookmarkUseCase
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.usecase.GetBookmarksListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class FavoriteScreenDomainModule {

    @Provides
    fun provideGetBookmarksListUseCase(bookmarkRepository: BookmarkRepository): GetBookmarksListUseCase {
        return GetBookmarksListUseCase(
            bookmarkRepository = bookmarkRepository
        )
    }

    @Provides
    fun provideDeleteBookmarkUseCase(bookmarkRepository: BookmarkRepository): DeleteBookmarkUseCase {
        return DeleteBookmarkUseCase(
            bookmarkRepository = bookmarkRepository
        )
    }

    @Provides
    fun provideDeleteAllBookmarksUseCase(bookmarkRepository: BookmarkRepository): DeleteAllBookmarksUseCase {
        return DeleteAllBookmarksUseCase(
            bookmarkRepository = bookmarkRepository
        )
    }
}