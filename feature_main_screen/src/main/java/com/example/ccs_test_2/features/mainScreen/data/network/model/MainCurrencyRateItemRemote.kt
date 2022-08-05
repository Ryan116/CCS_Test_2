package com.example.ccs_test_2.features.mainScreen.data.network.model

import com.example.ccs_test_2.common.constants.Constants
import com.example.ccs_test_2.common.constants.CurrencyCodeConstants
import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = Constants.CURRENCY_RATE_ITEM_REMOTE_ROOT_NAME, strict = false)
data class MainCurrencyRateItemRemote(
    @field:Element(name = Constants.CURRENCY_RATE_ITEM_REMOTE_ATTRIBUTE_NAME_NOMINAL)
    var nominal: Int = Constants.CURRENCY_RATE_ITEM_REMOTE_DEFAULT_VALUE_NOMINAL,
    @field:Element(name = Constants.CURRENCY_RATE_ITEM_REMOTE_ATTRIBUTE_NAME_CURRENCY_RATE_VALUE)
    var value: String = Constants.CURRENCY_RATE_ITEM_REMOTE_DEFAULT_VALUE_CURRENCY_RATE_VALUE,
    @field:Attribute(name = Constants.CURRENCY_RATE_ITEM_REMOTE_ATTRIBUTE_NAME_DATE)
    var date: String = Constants.CURRENCY_RATE_ITEM_REMOTE_DEFAULT_VALUE_DATE,
    @field:Attribute(name = Constants.CURRENCY_RATE_ITEM_REMOTE_ATTRIBUTE_NAME_ID)
    var id: String = Constants.CURRENCY_RATE_ITEM_REMOTE_DEFAULT_VALUE_ID
) {

    val currencyName: String
        get() = when (this.id) {
            CurrencyCodeConstants.USD.code -> {
                CurrencyCodeConstants.USD.name
            }
            CurrencyCodeConstants.AUD.code -> {
                CurrencyCodeConstants.AUD.name
            }
            CurrencyCodeConstants.AZN.code -> {
                CurrencyCodeConstants.AZN.name
            }
            CurrencyCodeConstants.GBP.code -> {
                CurrencyCodeConstants.GBP.name
            }
            CurrencyCodeConstants.AMD.code -> {
                CurrencyCodeConstants.AMD.name
            }
            CurrencyCodeConstants.BYN.code -> {
                CurrencyCodeConstants.BYN.name
            }
            CurrencyCodeConstants.BGN.code -> {
                CurrencyCodeConstants.BGN.name
            }
            CurrencyCodeConstants.BRL.code -> {
                CurrencyCodeConstants.BRL.name
            }
            CurrencyCodeConstants.HUF.code -> {
                CurrencyCodeConstants.HUF.name
            }
            CurrencyCodeConstants.HKD.code -> {
                CurrencyCodeConstants.HKD.name
            }
            else -> {
                CurrencyCodeConstants.USD.name
            }
        }
}

