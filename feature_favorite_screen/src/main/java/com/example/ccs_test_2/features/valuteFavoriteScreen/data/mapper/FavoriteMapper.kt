package com.example.ccs_test_2.features.valuteFavoriteScreen.data.mapper


import com.example.ccs_test_2.common.database.data.modelDB.CurrencyRateItemDB
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.model.RecordBookmark

class FavoriteMapper {
    fun mapListRecordDBToListRecordBookmark(listCurrencyRateItemDB: List<CurrencyRateItemDB>): List<RecordBookmark> {

        val listRecordBookmark: MutableList<RecordBookmark> = mutableListOf()

        listCurrencyRateItemDB.forEach {
            val recordBookmark = RecordBookmark(
                id = it.id,
                nominal = it.nominal,
                value = it.value,
                date = it.date
            )
            listRecordBookmark.add(recordBookmark)
        }
        return listRecordBookmark
    }

    fun mapRecordBookmarkToRecordDB(recordBookmark: RecordBookmark): CurrencyRateItemDB {
        return CurrencyRateItemDB(
            id = recordBookmark.id,
            nominal = recordBookmark.nominal,
            value = recordBookmark.value,
            date = recordBookmark.date
        )
    }
}