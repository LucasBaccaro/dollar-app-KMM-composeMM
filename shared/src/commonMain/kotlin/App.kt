import androidx.compose.runtime.Composable
import di.appModule
import org.koin.compose.KoinApplication
@Composable
fun App() {
    KoinApplication(moduleList = { appModule() }) {
        MainApp()
    }
}

@Composable
fun MainApp() {
    Navigation()
}


expect fun getPlatformName(): String