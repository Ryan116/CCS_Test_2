package com.example.ccs_test_2.features.favoriteScreen.data.mapper

import com.example.ccs_test_2.common.database.data.model.CurrencyRateItemDB
import com.example.ccs_test_2.features.favoriteScreen.domain.model.FavoriteCurrencyRateItem

class FavoriteMapper {

    fun mapListCurrencyRateItemDBToListFavoriteCurrencyRateItem(
        listCurrencyRateItemDB: List<CurrencyRateItemDB>
    ): List<FavoriteCurrencyRateItem> = listCurrencyRateItemDB.map {
        FavoriteCurrencyRateItem(
            id = it.id,
            nominal = it.nominal,
            value = it.value,
            date = it.date,
            currencyName = it.currencyName
        )
    }


    fun mapFavoriteCurrencyItemToCurrencyRateItemDB(
        favoriteCurrencyRateItem: FavoriteCurrencyRateItem
    ): CurrencyRateItemDB =
        CurrencyRateItemDB(
            id = favoriteCurrencyRateItem.id,
            nominal = favoriteCurrencyRateItem.nominal,
            value = favoriteCurrencyRateItem.value,
            date = favoriteCurrencyRateItem.date
        )
}