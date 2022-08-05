package com.example.ccs_test_2.di

import android.content.Context
import androidx.room.Room
import com.example.ccs_test_2.common.constants.Constants
import com.example.ccs_test_2.common.constants.Constants.BASE_URL
import com.example.ccs_test_2.common.database.data.database.BookmarkDao
import com.example.ccs_test_2.common.database.data.database.BookmarkDatabase
import com.example.ccs_test_2.features.mainScreen.data.dataSource.local.MainLocalDataSource
import com.example.ccs_test_2.features.mainScreen.data.dataSource.local.MainLocalDataSourceImpl
import com.example.ccs_test_2.features.mainScreen.data.dataSource.remote.MainRemoteDataSource
import com.example.ccs_test_2.features.mainScreen.data.dataSource.remote.MainRemoteDataSourceImpl
import com.example.ccs_test_2.features.mainScreen.data.mapper.MainMapper
import com.example.ccs_test_2.features.mainScreen.data.network.MainApi
import com.example.ccs_test_2.features.mainScreen.data.repository.MainRepositoryImpl
import com.example.ccs_test_2.features.mainScreen.domain.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MainDataModule {

    @Provides
    @Singleton
    fun provideMainRepository(
        mainRemoteDataSource: MainRemoteDataSource,
        mainMapper: MainMapper,
        mainLocalDataSource: MainLocalDataSource
    ): MainRepository {
        return MainRepositoryImpl(
            mainRemoteDataSource = mainRemoteDataSource,
            mainMapper = mainMapper,
            mainLocalDataSource = mainLocalDataSource
        )
    }

    @Provides
    @Singleton
    fun provideMainRemoteDataSource(mainApi: MainApi): MainRemoteDataSource {
        return MainRemoteDataSourceImpl(
            mainApi = mainApi
        )
    }

    @Provides
    @Singleton
    fun provideMainLocalDataSource(bookmarkDao: BookmarkDao): MainLocalDataSource {
        return MainLocalDataSourceImpl(
            bookmarkDao = bookmarkDao
        )
    }

    @Singleton
    @Provides
    fun provideMainApi(): MainApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
            .create(MainApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMainMapper(): MainMapper {
        return MainMapper()
    }

    @Singleton
    @Provides
    fun provideBookmardDao(bookmarkDatabase: BookmarkDatabase): BookmarkDao {
        return bookmarkDatabase.getBookmarkDao()
    }

    @Singleton
    @Provides
    fun provideBookmarkDatabase(
        @ApplicationContext context: Context
    ): BookmarkDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            BookmarkDatabase::class.java,
            Constants.BOOKMARK_DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}