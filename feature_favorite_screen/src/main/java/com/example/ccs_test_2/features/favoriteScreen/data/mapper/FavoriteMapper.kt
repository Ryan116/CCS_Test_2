package com.example.ccs_test_2.features.valuteFavoriteScreen.data.mapper

import com.example.ccs_test_2.common.database.data.modelDB.CurrencyRateItemDB
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.model.FavoriteCurrencyRateItem

class FavoriteMapper {

    fun mapListCurrencyRateItemDBToListFavoriteCurrencyRateItemDomain(
        listCurrencyRateItemDB: List<CurrencyRateItemDB>
    ): List<FavoriteCurrencyRateItem> {
        return listCurrencyRateItemDB.map {
            FavoriteCurrencyRateItem(
                id = it.id,
                nominal = it.nominal,
                value = it.value,
                date = it.date
            )
        }
    }

    fun mapFavoriteCurrencyItemToCurrencyRateItemDB(favoriteCurrencyRateItem: FavoriteCurrencyRateItem): CurrencyRateItemDB {
        return CurrencyRateItemDB(
            id = favoriteCurrencyRateItem.id,
            nominal = favoriteCurrencyRateItem.nominal,
            value = favoriteCurrencyRateItem.value,
            date = favoriteCurrencyRateItem.date
        )
    }
}