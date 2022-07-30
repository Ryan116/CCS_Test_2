package com.example.ccs_test_2.features.valuteFavoriteScreen.data.repository

import android.util.Log
import com.example.ccs_test_2.features.valuteFavoriteScreen.data.local.FavoriteLocalDataSource
import com.example.ccs_test_2.features.valuteFavoriteScreen.data.mapper.FavoriteMapper
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.model.RecordBookmark
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.repository.FavoriteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FavoriteRepositoryImpl(
    private val favoriteLocalDataSource: FavoriteLocalDataSource,
    private val favoriteMapper: FavoriteMapper
) : FavoriteRepository {


    override suspend fun getBookmarks(): Flow<List<RecordBookmark>> {

            return favoriteLocalDataSource.getBookmarks().map{
                Log.d("Valute", it.toString())
                favoriteMapper.mapListRecordDBToListRecordBookmark(it)
            }
    }

    override suspend fun deleteBookmark(recordBookmark: RecordBookmark) {
        favoriteLocalDataSource.deleteBookmark(favoriteMapper.mapRecordBookmarkToRecordDB(recordBookmark))
    }

    override suspend fun deleteAllBookmarks() {
        favoriteLocalDataSource.deleteAllBookmarks()
    }


}