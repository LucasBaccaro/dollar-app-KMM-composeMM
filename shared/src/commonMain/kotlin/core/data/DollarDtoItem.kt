package core.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class DolarDTOItem(
    @SerialName("casa") val casa: String,
    @SerialName("compra") val compra: Double?,
    @SerialName("fechaActualizacion") val fechaActualizacion: String,
    @SerialName("moneda") val moneda: String,
    @SerialName("nombre") val nombre: String,
    @SerialName("venta") val venta: Double
)