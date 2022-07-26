package com.example.ccs_test_2.features.valuteListScreen.data.network.modelRemote

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "Record", strict = false)
data class RecordRemote(
    @field:Element(name = "Nominal")
    var nominal: Int? = null,
    @field:Element(name = "Value")
    var value: String? = null,
    @field:Attribute(name = "Date")
    var date: String? = null,
    @field:Attribute(name = "Id")
    var id: String? = null
)

