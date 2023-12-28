package domain

import kotlinx.serialization.Serializable
@Serializable
data class DolarModel(
    val casa: String,
    val compra: String?,
    val fechaActualizacion: String,
    val moneda: String,
    val nombre: String,
    val venta: String
)