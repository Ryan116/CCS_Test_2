package com.example.ccs_test_2.di

import com.example.ccs_test_2.features.favoriteScreen.domain.repository.FavoriteRepository
import com.example.ccs_test_2.features.favoriteScreen.domain.usecase.DeleteAllBookmarksUseCase
import com.example.ccs_test_2.features.favoriteScreen.domain.usecase.DeleteBookmarkUseCase
import com.example.ccs_test_2.features.favoriteScreen.domain.usecase.GetBookmarksListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class FavoriteDomainModule {

    @Provides
    fun provideGetBookmarksListUseCase(favoriteRepository: FavoriteRepository): GetBookmarksListUseCase {
        return GetBookmarksListUseCase(
            favoriteRepository = favoriteRepository
        )
    }

    @Provides
    fun provideDeleteBookmarkUseCase(favoriteRepository: FavoriteRepository): DeleteBookmarkUseCase {
        return DeleteBookmarkUseCase(
            favoriteRepository = favoriteRepository
        )
    }

    @Provides
    fun provideDeleteAllBookmarksUseCase(favoriteRepository: FavoriteRepository): DeleteAllBookmarksUseCase {
        return DeleteAllBookmarksUseCase(
            favoriteRepository = favoriteRepository
        )
    }
}