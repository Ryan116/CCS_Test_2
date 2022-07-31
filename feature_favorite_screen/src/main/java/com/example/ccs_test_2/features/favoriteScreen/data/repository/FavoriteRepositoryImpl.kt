package com.example.ccs_test_2.features.valuteFavoriteScreen.data.repository

import com.example.ccs_test_2.features.valuteFavoriteScreen.data.local.FavoriteLocalDataSource
import com.example.ccs_test_2.features.valuteFavoriteScreen.data.mapper.FavoriteMapper
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.model.FavoriteCurrencyRateItem
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.repository.FavoriteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FavoriteRepositoryImpl(
    private val favoriteLocalDataSource: FavoriteLocalDataSource,
    private val favoriteMapper: FavoriteMapper
) : FavoriteRepository {


    override suspend fun getBookmarks(): Flow<List<FavoriteCurrencyRateItem>> {
        return favoriteLocalDataSource.getBookmarksList().map {
            favoriteMapper.mapListCurrencyRateItemDBToListFavoriteCurrencyRateItemDomain(it)
        }
    }

    override suspend fun deleteBookmark(favoriteCurrencyRateItem: FavoriteCurrencyRateItem) {
        favoriteLocalDataSource.deleteBookmark(
            favoriteMapper.mapFavoriteCurrencyItemToCurrencyRateItemDB(
                favoriteCurrencyRateItem
            )
        )
    }

    override suspend fun deleteAllBookmarks() {
        favoriteLocalDataSource.deleteAllBookmarks()
    }


}