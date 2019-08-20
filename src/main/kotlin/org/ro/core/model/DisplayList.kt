package org.ro.core.model

import kotlinx.serialization.Serializable
import org.ro.layout.Layout
import org.ro.to.Extensions
import org.ro.to.Property
import org.ro.to.TObject

@Serializable
class DisplayList(val title: String) {
    private val data = mutableListOf<MemberExposer>()
    var layout: Layout? = null
    val propertyLabels = mutableMapOf<String, String>()
    var properties = mutableListOf<Property>()
    var isRendered = false

    fun canBeDisplayed(): Boolean {
        if (layout == null) {
            return false
        } else {
            val lps = layout!!.properties.size
            return (lps <= propertyLabels.size)
                    && (lps <= properties.size)
                    && !isRendered
        }
    }

    // List<MemberExposer<TObject>>
    fun addData(obj: TObject) {
        data.add(MemberExposer(obj).dynamise())
    }

    fun getData(): MutableList<MemberExposer> {
        return data
    }

    // PropertyDescription
    fun addPropertyLabel(p: Property) {
        val id = p.id
        val e: Extensions = p.extensions!!
        val friendlyName = e.friendlyName
        propertyLabels.put(id, friendlyName)
    }

    fun getPropertyLabel(key: String): String? {
        return propertyLabels.get(key)
    }

    // Property
    fun addProperty(property: Property) {
        properties.add(property)
    }

    fun getMembers(): Map<String, String> {
        val members = mutableMapOf<String, String>()
        console.log(this)
        if (layout != null) {
            for (p in properties) {
                val key = p.id
                val columnTitle = getPropertyLabel(key)
                if (columnTitle != null) {
                    members.put(columnTitle, key)
                }
            }
        }
        console.log(members)
        return members
    }

}