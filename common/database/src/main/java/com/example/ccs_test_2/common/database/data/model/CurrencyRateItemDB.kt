package com.example.ccs_test_2.common.database.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ccs_test_2.common.constants.Constants.CURRENCY_RATE_ITEM_DB_NAME_DEFAULT_VALUE
import com.example.ccs_test_2.common.constants.Constants.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class CurrencyRateItemDB(
    val id: String,
    val nominal: Int,
    @PrimaryKey()
    val value: String,
    val date: String,
    val currencyName: String = CURRENCY_RATE_ITEM_DB_NAME_DEFAULT_VALUE
)