package com.example.ccs_test_2.features.favoriteScreen.data.repository

import com.example.ccs_test_2.features.favoriteScreen.data.local.FavoriteLocalDataSource
import com.example.ccs_test_2.features.favoriteScreen.data.mapper.FavoriteMapper
import com.example.ccs_test_2.features.favoriteScreen.domain.model.FavoriteCurrencyRateItem
import com.example.ccs_test_2.features.favoriteScreen.domain.repository.FavoriteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FavoriteRepositoryImpl(
    private val favoriteLocalDataSource: FavoriteLocalDataSource,
    private val favoriteMapper: FavoriteMapper
) : FavoriteRepository {

    override suspend fun getBookmarks(): Flow<List<FavoriteCurrencyRateItem>> =
        favoriteLocalDataSource.getBookmarksList().map {
            favoriteMapper.mapListCurrencyRateItemDBToListFavoriteCurrencyRateItem(it)
        }


    override suspend fun deleteBookmark(favoriteCurrencyRateItem: FavoriteCurrencyRateItem) {
        favoriteLocalDataSource.deleteBookmark(
            favoriteMapper.mapFavoriteCurrencyRateItemToCurrencyRateItemDB(
                favoriteCurrencyRateItem
            )
        )
    }

    override suspend fun deleteAllBookmarks() {
        favoriteLocalDataSource.deleteAllBookmarks()
    }
}