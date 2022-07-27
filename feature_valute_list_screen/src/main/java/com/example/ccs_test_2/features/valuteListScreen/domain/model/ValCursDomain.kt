package com.example.ccs_test_2.features.valuteListScreen.domain.model

import com.example.ccs_test_2.features.valuteListScreen.domain.model.RecordDomain


data class ValCursDomain(
    var id: String? = null,
    var dateRange1: String? = null,
    var dateRange2: String? = null,
    var name: String? = null,
    var recordList: List<RecordDomain>? = null
)


