package org.ro.ui

import org.ro.core.event.LogEntry
import org.ro.to.ResultValue
import org.ro.ui.kv.RoDialog
import org.ro.ui.uicomp.FormItem

class FileAlert(val logEntry: LogEntry) : Command {

    fun open() {
        val rv = logEntry.getObj() as ResultValue
        val rvr = rv.result!!
        val value = rvr.value!!.content as String
        val list = value.split(":")
        val formItems = mutableListOf<FormItem>()
        formItems.add(FormItem("URL", "Text", logEntry.url))
        formItems.add(FormItem("Blob", "TextArea", list[2], 20))
        val label = list[0] + "/" + list[1]
        RoDialog(label = label, items = formItems, command = this).show()
    }

    override fun execute() {
        //do nothing
    }

}