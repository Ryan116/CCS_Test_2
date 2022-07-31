package com.example.ccs_test_2.features.mainScreen.domain.model

import com.example.ccs_test_2.common.constants.CurrencyCodeConstants

data class MainCurrencyRateItem(
    val nominal: Int,
    val value: String,
    val date: String,
    val id: String,
    var pressed: Boolean = false
) {
    val currencyName: String
        get() = when(this.id) {
            CurrencyCodeConstants.USD.code -> {CurrencyCodeConstants.USD.name}
            CurrencyCodeConstants.AUD.code -> {CurrencyCodeConstants.AUD.name}
            CurrencyCodeConstants.AZN.code -> {CurrencyCodeConstants.AZN.name}
            CurrencyCodeConstants.GBP.code -> {CurrencyCodeConstants.GBP.name}
            CurrencyCodeConstants.AMD.code -> {CurrencyCodeConstants.AMD.name}
            CurrencyCodeConstants.BYN.code -> {CurrencyCodeConstants.BYN.name}
            CurrencyCodeConstants.BGN.code -> {CurrencyCodeConstants.BGN.name}
            CurrencyCodeConstants.BRL.code -> {CurrencyCodeConstants.BRL.name}
            CurrencyCodeConstants.HUF.code -> {CurrencyCodeConstants.HUF.name}
            CurrencyCodeConstants.HKD.code -> {CurrencyCodeConstants.HKD.name}
            else -> {
                CurrencyCodeConstants.USD.name
            }
        }
}