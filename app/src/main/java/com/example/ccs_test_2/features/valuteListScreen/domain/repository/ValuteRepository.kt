package com.example.ccs_test_2.features.valuteListScreen.domain.repository

import androidx.lifecycle.LiveData
import com.example.ccs_test_2.features.valuteListScreen.domain.model.RecordDomain

interface ValuteRepository {
    suspend fun getValuteCurs(dateFrom: String, dateBefore: String): LiveData<List<RecordDomain>>
}