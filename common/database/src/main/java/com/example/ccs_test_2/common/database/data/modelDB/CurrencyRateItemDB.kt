package com.example.ccs_test_2.common.database.data.modelDB

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ccs_test_2.common.constants.Constants.TABLE_NAME


@Entity(tableName = TABLE_NAME)
data class CurrencyRateItemDB(
    var id: String,
    var nominal: Int,
    @PrimaryKey()
    var value: String,
    var date: String
)