package com.example.ccs_test_2.features.valuteListScreen.data.mapper
import com.example.ccs_test_2.common.database.data.modelDB.RecordDB
import com.example.ccs_test_2.features.valuteListScreen.data.network.modelRemote.RecordRemote
import com.example.ccs_test_2.features.valuteListScreen.domain.model.RecordDomain


class MainMapper {
    fun mapListRecordRemoteToListRecordDomain(listRecordRemote: List<RecordRemote>): List<RecordDomain> {

        val listRecord: MutableList<RecordDomain> = mutableListOf()

        listRecordRemote.forEach {
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

    fun mapRecordDomainToRecordDB(recordDomain: RecordDomain): RecordDB {
        return RecordDB(
            id = recordDomain.id,
            nominal = recordDomain.nominal,
            value = recordDomain.value,
            date = recordDomain.date
        )
    }
}