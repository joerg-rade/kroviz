package org.ro.bs3.parser

import org.ro.bs3.parser.BaseXmlHandler
import org.ro.bs3.to.Bs3Object
import org.ro.bs3.to.ClearFixVisible
import org.ro.bs3.to.CssDisplay
import org.ro.bs3.to.Size

class ClearFixHiddenHandler : BaseXmlHandler() {
    override fun doHandle() {
//        logEntry.aggregator = NavigationAggregator()
        //      update()
    }

    override fun parse(xmlStr: String): Bs3Object? {
        //TODO dive into sub elements, create objects and use in constructor     #
        val cssDisplay= CssDisplay.BLOCK
        val size = Size.LG
        val cssClass = ""
        return ClearFixVisible(
                cssDisplay,
                size,
                cssClass)
    }
}