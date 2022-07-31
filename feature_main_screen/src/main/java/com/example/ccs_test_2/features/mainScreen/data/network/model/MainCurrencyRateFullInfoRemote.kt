package com.example.ccs_test_2.features.mainScreen.data.network.model

import com.example.ccs_test_2.common.constants.Constants
import org.simpleframework.xml.Attribute
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = Constants.CURRENCY_RATE_FULL_INFO_REMOTE_ROOT_NAME, strict = false)
data class MainCurrencyRateFullInfoRemote(
    @field:Attribute(name = Constants.CURRENCY_RATE_FULL_INFO_REMOTE_ATTRIBUTE_NAME_ID, required = false)
    var id: String = Constants.DEFAULT_VALUE_CURRENCY_CODE,
    @field:Attribute(name = Constants.CURRENCY_RATE_FULL_INFO_REMOTE_ATTRIBUTE_NAME_DATE_RANGE_1, required = false)
    var dateRange1: String = Constants.DEFAULT_VALUE_DATE_RANGE_1,
    @field:Attribute(name = Constants.CURRENCY_RATE_FULL_INFO_REMOTE_ATTRIBUTE_NAME_DATE_RANGE_2, required = false)
    var dateRange2: String = Constants.DEFAULT_VALUE_DATE_RANGE_2,
    @field:Attribute(name = Constants.CURRENCY_RATE_FULL_INFO_REMOTE_ATTRIBUTE_NAME_CURRENCY_RATE_NAME, required = false)
    var name: String = Constants.DEFAULT_VALUE_CURRENCY_RATE_NAME,
    @field:ElementList(name = Constants.CURRENCY_RATE_FULL_INFO_REMOTE_ATTRIBUTE_NAME_RECORD_LIST, required = false, inline = true)
    var recordList: List<MainCurrencyRateItemRemote> = mutableListOf()
)

