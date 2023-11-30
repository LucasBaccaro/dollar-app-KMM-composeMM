package domain

import core.data.DolarDTOItem
import core.data.DollarRepository
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import Result
import mapSuccess
import toSuccess


class GetDollarsUseCase(
    private val dollarRepository: DollarRepository,
) {
    suspend operator fun invoke(): Result<List<DolarModel>> {
        return dollarRepository.getDollars().mapSuccess{ it ->
            it.data.map { it.asDollarModel() }.toSuccess()
        }
    }
}

fun DolarDTOItem.asDollarModel(): DolarModel {
    return DolarModel(
        casa = this.casa,
        compra = "$ ${this.compra}",
        fechaActualizacion = formatterDate(this.fechaActualizacion),
        moneda = this.moneda,
        nombre = this.nombre,
        venta = "$ ${this.venta}"
    )
}


private fun formatterDate(fecha: String): String {
    val originalString = fecha
    val instant = Instant.parse(originalString)
    val localDateTime = instant.toLocalDateTime(TimeZone.UTC)
    val formattedDate = "${localDateTime.year}-${
        localDateTime.monthNumber.toString().padStart(2, '0')
    }-${localDateTime.dayOfMonth.toString().padStart(2, '0')}"
    return formattedDate
}