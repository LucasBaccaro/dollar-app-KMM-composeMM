package core.data

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json

class DollarRepository(private val client: HttpClient) {
    suspend fun getDollars(): Result<List<DolarDTOItem>> {
        return try {
            val response: HttpResponse = client.get("https://www.dolarapi.com/v1/dolares")
            val responseBody: String = response.bodyAsText()
            val dollarItems: List<DolarDTOItem> = Json.decodeFromString(responseBody)
            Result.Success(dollarItems)
        } catch (e: Exception) {
            Result.Error("Error al obtener los datos: ${e.message}")
        }
    }
}