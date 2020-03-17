package org.ro.core.model

import org.ro.layout.Layout
import org.ro.layout.PropertyLt
import org.ro.layout.RowLt
import org.ro.to.Extensions
import org.ro.to.Property
import org.ro.to.TObject
import org.ro.to.TransferObject
import org.ro.to.bs3.Grid
import pl.treksoft.kvision.state.observableListOf

class ListDM(override val title: String) : DisplayModel() {
    var data = observableListOf<Exposer>()
    override var layout: Layout? = null
    var grid: Grid? = null
    var propertyDescriptionList = mutableMapOf<String, String>()
    var propertyList = mutableListOf<Property>()
    var propertyLayoutList = mutableListOf<PropertyLt>()

    override fun canBeDisplayed(): Boolean {
        when {
            isRendered -> return false
            layout == null -> return false
            grid == null -> return false
            else -> {
                val pls = propertyLayoutList.size
                val pds = propertyDescriptionList.size
                val descriptionsComplete = pds >= pls
                return descriptionsComplete
            }
        }
    }

    fun addLayout(layout: Layout) {
        this.layout = layout
        initPropertyLayoutList(layout)
    }

    private fun initPropertyLayoutList(layout: Layout) {
        layout.row.forEach { r ->
            initLayout4Row(r)
        }
    }

    private fun initLayout4Row(r: RowLt) {
        r.cols.forEach { cs ->
            val c = cs.getCol()
            c.fieldSet.forEach { fs ->
                propertyLayoutList.addAll(fs.property)
            }
            c.tabGroup.forEach { tg ->
                tg.tab.forEach { t ->
                    t.row.forEach { r2 ->
                        initLayout4Row(r2)
                    }
                }
            }
        }
    }

    override fun addData(obj: TransferObject) {
        val exo = Exposer(obj as TObject)
        data.add(exo.dynamise())  //if exposer is not dynamised, data access in tables won't work
    }

    fun addPropertyDescription(p: Property) {
        val id = p.id
        val e: Extensions = p.extensions!!
        val friendlyName = e.friendlyName
        addPropertyDescription(id, friendlyName)
    }

    fun addPropertyDescription(key: String, value: String) {
        propertyDescriptionList.put(key, value)
    }

    fun addProperty(property: Property) {
        propertyList.add(property)
    }

    override fun reset() {
        isRendered = false
        data = observableListOf<Exposer>()
    }

}