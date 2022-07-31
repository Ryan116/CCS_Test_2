package com.example.ccs_test_2.common.database.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ccs_test_2.common.constants.Constants.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class CurrencyRateItemDB(
    val id: String,
    val nominal: Int,
    @PrimaryKey()
    val value: String,
    val date: String,
    val currencyName: String = ""
)