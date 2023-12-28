package di

import core.data.DollarRepository
import core.network.ktorHttpClient
import domain.GetDollarsUseCase
import org.koin.dsl.module
import ui.DollarViewModel

val sharedModules = module {

    single { ktorHttpClient() }
    single { DollarRepository(client = get()) }
    single { GetDollarsUseCase(dollarRepository = get()) }
    single { DollarViewModel(getDollarsUseCase = get()) }
}
fun appModule() = listOf(sharedModules)