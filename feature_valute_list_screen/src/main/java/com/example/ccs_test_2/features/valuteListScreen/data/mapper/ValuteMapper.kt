package com.example.ccs_test_2.features.valuteListScreen.data.mapper
import com.example.ccs_test_2.features.valuteListScreen.data.network.modelRemote.RecordRemote
import com.example.ccs_test_2.features.valuteListScreen.domain.model.RecordDomain


class ValuteMapper {
    fun mapListRecordDBToListRecord(listRecordDB: List<RecordRemote>): List<RecordDomain> {

        val listRecord: MutableList<RecordDomain> = mutableListOf()

        listRecordDB.forEach {
            val record = RecordDomain(
                nominal = it.nominal,
                value = it.value,
                date = it.date,
                id = it.id
            )
            listRecord.add(record)
        }
        return listRecord
    }
}