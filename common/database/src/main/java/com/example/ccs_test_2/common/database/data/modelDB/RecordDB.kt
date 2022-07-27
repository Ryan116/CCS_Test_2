package com.example.ccs_test_2.common.database.data.modelDB

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "currency_table")
data class RecordDB(
    var id: String,
    var nominal: Int,
    @PrimaryKey()
    var value: String,
    var date: String
)