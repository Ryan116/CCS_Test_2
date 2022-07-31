package com.example.ccs_test_2.features.mainScreen.data.mapper

import com.example.ccs_test_2.common.database.data.model.CurrencyRateItemDB
import com.example.ccs_test_2.features.mainScreen.data.network.model.MainCurrencyRateItemRemote
import com.example.ccs_test_2.features.mainScreen.domain.model.MainCurrencyRateItem

class MainMapper {

    fun mapMainCurrencyRateItemToCurrencyRateItemDB(
        mainCurrencyRateItem: MainCurrencyRateItem
    ): CurrencyRateItemDB {
        return CurrencyRateItemDB(
            id = mainCurrencyRateItem.id,
            nominal = mainCurrencyRateItem.nominal,
            value = mainCurrencyRateItem.value,
            date = mainCurrencyRateItem.date,
            currencyName = mainCurrencyRateItem.currencyName
        )
    }

    fun mapMainCurrencyRateItemRemoteToMainCurrencyRateItem(
        mainCurrencyRateItemRemote: MainCurrencyRateItemRemote
    ): MainCurrencyRateItem {
        return MainCurrencyRateItem(
            nominal = mainCurrencyRateItemRemote.nominal,
            value = mainCurrencyRateItemRemote.value,
            date = mainCurrencyRateItemRemote.date,
            id = mainCurrencyRateItemRemote.id
        )
    }
}