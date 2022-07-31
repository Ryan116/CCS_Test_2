package com.example.ccs_test_2.features.mainScreen.domain.model

data class MainCurrencyRateItem(
    var nominal: Int,
    var value: String,
    var date: String,
    var id: String,
    var pressed: Boolean = false
)