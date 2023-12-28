import androidx.compose.runtime.Composable
import di.appModule
import moe.tlaster.precompose.PreComposeApp
import org.koin.compose.KoinApplication
@Composable
fun App() {
    KoinApplication(moduleList = { appModule() }) {
        PreComposeApp {
            MainApp()
        }
    }
}

@Composable
fun MainApp() {
    Navigation()
}

expect fun getPlatformName(): String