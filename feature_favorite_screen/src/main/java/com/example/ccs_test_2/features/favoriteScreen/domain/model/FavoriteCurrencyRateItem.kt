package com.example.ccs_test_2.features.favoriteScreen.domain.model


data class FavoriteCurrencyRateItem(
    val id: String,
    val nominal: Int,
    val value: String,
    val date: String,
    val currencyName: String
)