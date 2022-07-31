package com.example.ccs_test_2.features.valuteListScreen.data.network.modelRemote

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "Record", strict = false)
data class RecordRemote(
    @field:Element(name = "Nominal")
    var nominal: Int = 1,
    @field:Element(name = "Value")
    var value: String = "0.00",
    @field:Attribute(name = "Date")
    var date: String = "01/01/2001",
    @field:Attribute(name = "Id")
    var id: String = "R01235"
)

