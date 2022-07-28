package com.example.ccs_test_2.di

import android.app.Application
import android.content.Context
import com.example.ccs_test_2.common.database.data.database.BookmarkDao
import com.example.ccs_test_2.common.database.data.database.BookmarkDatabase
import com.example.ccs_test_2.features.valuteFavoriteScreen.data.local.FavoriteLocalDataSource
import com.example.ccs_test_2.features.valuteFavoriteScreen.data.local.FavoriteLocalDataSourceImpl
import com.example.ccs_test_2.features.valuteFavoriteScreen.data.mapper.BookmarkScreenMapper
import com.example.ccs_test_2.features.valuteFavoriteScreen.data.repository.BookmarkRepositoryImpl
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.repository.BookmarkRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FavoriteScreenDataModule {

    @Provides
    @Singleton
    fun provideBookmarkRepository(favoriteLocalDataSource: FavoriteLocalDataSource, bookmarkScreenMapper: BookmarkScreenMapper): BookmarkRepository {
        return BookmarkRepositoryImpl(
            favoriteLocalDataSource = favoriteLocalDataSource,
            bookmarkScreenMapper = bookmarkScreenMapper
        )
    }

    @Provides
    @Singleton
    fun provideFavoriteLocalDataSource(bookmarkDao: BookmarkDao): FavoriteLocalDataSource {
        return FavoriteLocalDataSourceImpl(bookmarkDao = bookmarkDao)
    }

    @Provides
    @Singleton
    fun provideBookmarkScreenMapper(): BookmarkScreenMapper {
        return BookmarkScreenMapper()
    }



}