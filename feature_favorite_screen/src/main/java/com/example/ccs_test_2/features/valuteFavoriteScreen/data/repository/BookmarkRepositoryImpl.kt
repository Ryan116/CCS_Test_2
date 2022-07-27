package com.example.ccs_test_2.features.valuteFavoriteScreen.data.repository

import com.example.ccs_test_2.features.valuteFavoriteScreen.data.local.FavoriteLocalDataSource
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.model.RecordBookmark
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.repository.BookmarkRepository
import com.example.ccs_test_2.features.valuteFavoriteScreen.data.mapper.BookmarkScreenMapper

class BookmarkRepositoryImpl(
    private val favoriteLocalDataSource: FavoriteLocalDataSource,
    private val bookmarkScreenMapper: BookmarkScreenMapper
) : BookmarkRepository {

    override suspend fun getBookmarks():List<RecordBookmark> {
        return bookmarkScreenMapper.mapListRecordDBToListRecordBookmark(favoriteLocalDataSource.getBookmarks())
    }

    override suspend fun deleteBookmark(recordBookmark: RecordBookmark) {
        favoriteLocalDataSource.deleteBookmark(bookmarkScreenMapper.mapRecordBookmarkToRecordDB(recordBookmark))
    }

    override suspend fun deleteAllBookmarks() {
        favoriteLocalDataSource.deleteAllBookmarks()
    }


}