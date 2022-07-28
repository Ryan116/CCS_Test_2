package com.example.ccs_test_2.di

import android.app.Application
import android.content.Context
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
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ValuteListScreenDataModule {

    @Provides
    @Singleton
    fun provideValuteRepository(
        valuteRemoteDataSource: ValuteRemoteDataSource,
        valuteMapper: ValuteMapper,
        valuteLocalDataSource: ValuteLocalDataSource
    ): ValuteRepository {
        return ValuteRepositoryImpl(
            valuteRemoteDataSource = valuteRemoteDataSource,
            valuteMapper = valuteMapper,
            valuteLocalDataSource = valuteLocalDataSource
        )
    }

    @Provides
    @Singleton
    fun provideValuteRemoteDataSource(valuteApiInterface: ValuteApiInterface): ValuteRemoteDataSource {
        return ValuteRemoteDataSourceImpl(
            valuteApiInterface =  valuteApiInterface
        )
    }

    @Provides
    @Singleton
    fun provideValuteLocalDataSource(bookmarkDao: BookmarkDao): ValuteLocalDataSource {
        return ValuteLocalDataSourceImpl(
            bookmarkDao =  bookmarkDao
        )
    }

    @Provides
    @Singleton
    fun provideValuteApiInterface(): ValuteApiInterface {
        return ValuteApi.retrofitService
    }

    @Provides
    @Singleton
    fun provideValuteMapper(): ValuteMapper {
        return ValuteMapper()
    }

    @Provides
    @Singleton
    fun provideBookmardDao(@ApplicationContext context: Context): BookmarkDao {
        return BookmarkDatabase.getDatabase(context.applicationContext as Application).bookmarkDao()
    }


}