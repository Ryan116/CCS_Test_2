package com.example.ccs_test_2.features.mainScreen.domain.model

data class MainCurrencyRateItem(
    val nominal: Int,
    val value: String,
    val date: String,
    val id: String,
    var pressed: Boolean = false,
    val currencyName: String
)