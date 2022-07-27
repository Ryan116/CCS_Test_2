package com.example.ccs_test_2.features.valuteListScreen.data.network.modelRemote

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "ValCurs", strict = false)
data class ValCursRemote(
    @field:Attribute(name = "ID", required = false)
    var id: String? = null,
    @field:Attribute(name = "DateRange1", required = false)
    var dateRange1: String? = null,
    @field:Attribute(name = "DateRange2", required = false)
    var dateRange2: String? = null,
    @field:Attribute(name = "name", required = false)
    var name: String? = null,
    @field:ElementList(name = "recordList", required = false, inline = true)
    var recordList: List<RecordRemote>? = null
)

