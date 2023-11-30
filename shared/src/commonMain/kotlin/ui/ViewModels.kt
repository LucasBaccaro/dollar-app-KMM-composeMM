

import androidx.compose.runtime.Composable
import moe.tlaster.precompose.viewmodel.ViewModel
import org.koin.compose.LocalKoinScope
import org.koin.core.parameter.ParametersDefinition
import kotlin.reflect.KClass

@Composable
fun <T : ViewModel> koinViewModel(
    viewModelClass: KClass<T>,
    parameters: ParametersDefinition? = null
): T {
    val koin = LocalKoinScope.current
    return koin.get(clazz = viewModelClass, parameters = parameters)
}


