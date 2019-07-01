package org.ro.core.event

import kotlinx.serialization.*
import kotlinx.serialization.internal.StringDescriptor
import kotlin.js.Date

@Serializer(forClass = Date::class)
object DateSerializer : KSerializer<Date> {
    //private val df: DateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS")

    override val descriptor: SerialDescriptor =
            StringDescriptor.withName("Date")

    override fun serialize(output: Encoder, obj: Date) {
        output.encodeString(obj.toDateString())
    }

    override fun deserialize(input: Decoder): Date {
        val input = input.decodeString()
        val double = Date.parse(input)
        val long = double as Long
        val result = Date(milliseconds = long)
        return result
    }
}