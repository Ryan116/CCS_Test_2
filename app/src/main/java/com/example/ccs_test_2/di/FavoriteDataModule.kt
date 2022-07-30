package com.example.ccs_test_2.di

import com.example.ccs_test_2.common.database.data.database.BookmarkDao
import com.example.ccs_test_2.features.valuteFavoriteScreen.data.local.FavoriteLocalDataSource
import com.example.ccs_test_2.features.valuteFavoriteScreen.data.local.FavoriteLocalDataSourceImpl
import com.example.ccs_test_2.features.valuteFavoriteScreen.data.mapper.FavoriteMapper
import com.example.ccs_test_2.features.valuteFavoriteScreen.data.repository.FavoriteRepositoryImpl
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.repository.FavoriteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FavoriteDataModule {

    @Provides
    @Singleton
    fun provideFavoriteRepository(
        favoriteLocalDataSource: FavoriteLocalDataSource,
        favoriteMapper: FavoriteMapper
    ): FavoriteRepository {
        return FavoriteRepositoryImpl(
            favoriteLocalDataSource = favoriteLocalDataSource,
            favoriteMapper = favoriteMapper
        )
    }

    @Provides
    @Singleton
    fun provideFavoriteLocalDataSource(bookmarkDao: BookmarkDao): FavoriteLocalDataSource {
        return FavoriteLocalDataSourceImpl(bookmarkDao = bookmarkDao)
    }

    @Provides
    @Singleton
    fun provideFavoriteMapper(): FavoriteMapper {
        return FavoriteMapper()
    }
}