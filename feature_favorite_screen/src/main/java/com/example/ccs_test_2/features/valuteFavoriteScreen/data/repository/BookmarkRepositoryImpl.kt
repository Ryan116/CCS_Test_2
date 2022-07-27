package com.example.ccs_test_2.features.valuteFavoriteScreen.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.ccs_test_2.common.database.data.modelDB.RecordDB
import com.example.ccs_test_2.features.valuteFavoriteScreen.data.local.FavoriteLocalDataSource
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.model.RecordBookmark
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.repository.BookmarkRepository
import com.example.ccs_test_2.features.valuteFavoriteScreen.data.mapper.BookmarkScreenMapper

class BookmarkRepositoryImpl(
    private val favoriteLocalDataSource: FavoriteLocalDataSource,
    private val bookmarkScreenMapper: BookmarkScreenMapper
) : BookmarkRepository {

    override suspend fun getBookmarks(): LiveData<List<RecordBookmark>> {
        return Transformations.map(favoriteLocalDataSource.getBookmarks()) {
            bookmarkScreenMapper.mapListRecordDBToListRecordBookmark(it)
        }
    }

    override suspend fun deleteBookmark(recordBookmark: RecordBookmark) {
        favoriteLocalDataSource.deleteBookmark(bookmarkScreenMapper.mapRecordBookmarkToRecordDB(recordBookmark))
    }

    override suspend fun deleteAllBookmarks() {
        favoriteLocalDataSource.deleteAllBookmarks()
    }


}