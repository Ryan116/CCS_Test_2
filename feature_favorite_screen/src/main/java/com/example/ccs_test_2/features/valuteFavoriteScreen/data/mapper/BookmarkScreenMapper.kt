package com.example.ccs_test_2.features.valuteFavoriteScreen.data.mapper


import com.example.ccs_test_2.common.database.data.modelDB.RecordDB
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.model.RecordBookmark

class BookmarkScreenMapper {
    fun mapListRecordDBToListRecordBookmark(listRecordDB: List<RecordDB>): List<RecordBookmark> {

        val listRecordBookmark: MutableList<RecordBookmark> = mutableListOf()

        listRecordDB.forEach {
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

    fun mapRecordBookmarkToRecordDB(recordBookmark: RecordBookmark): RecordDB {
        return RecordDB(
            id = recordBookmark.id,
            nominal = recordBookmark.nominal,
            value = recordBookmark.value,
            date = recordBookmark.date
        )
    }
}