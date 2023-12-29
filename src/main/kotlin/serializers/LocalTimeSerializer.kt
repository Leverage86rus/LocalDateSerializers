package serializers

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.LocalTime
import java.time.format.DateTimeFormatter

object LocalTimeSerializer : KSerializer<LocalTime> {
    override val descriptor = PrimitiveSerialDescriptor(LocalTime::class.simpleName!!, PrimitiveKind.STRING)
    override fun deserialize(decoder: Decoder): LocalTime = LocalTime.parse(decoder.decodeString())
    override fun serialize(encoder: Encoder, value: LocalTime) = encoder.encodeString(value.format(DateTimeFormatter.ISO_DATE))
}