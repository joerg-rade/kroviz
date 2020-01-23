package org.ro.core.aggregator

import org.ro.core.event.LogEntry
import org.ro.ui.Point
import org.w3c.dom.parsing.DOMParser
import kotlin.browser.document

class DiagramDispatcher(val at: Point = Point(100,100)) : BaseAggregator() {

    override fun update(logEntry: LogEntry) {
        val response = logEntry.response
        val p = DOMParser()
        val svg = p.parseFromString(response, "image/svg+xml")
        val dp = document.getElementById("diagramPanel")
        dp.asDynamic().appendChild(svg.documentElement)
    }

}