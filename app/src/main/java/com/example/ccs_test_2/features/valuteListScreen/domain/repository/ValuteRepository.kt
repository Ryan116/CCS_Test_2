package com.example.ccs_test_2.features.valuteListScreen.domain.repository

import com.example.ccs_test_2.features.valuteListScreen.domain.model.RecordDomain

interface ValuteRepository {
    suspend fun getValuteCurs(
        dateFrom: String,
        dateBefore: String,
        valuteCode: String
    ): List<RecordDomain>

    suspend fun addBookmark(recordDomain: RecordDomain)

    suspend fun deleteBookmark(recordDomain: RecordDomain)
}