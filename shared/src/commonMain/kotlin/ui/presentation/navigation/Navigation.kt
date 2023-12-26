
import androidx.compose.runtime.Composable
import com.dolarapp.ui.presentation.HomeScreen
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator
import moe.tlaster.precompose.navigation.transition.NavTransition


@Composable
fun Navigation() {
    val navigator = rememberNavigator()
    NavHost(
        navigator = navigator,
        navTransition = NavTransition(),
        initialRoute = "/home",
    ) {
        scene(
            route = "/home",
            navTransition = NavTransition(),
        ) {
            HomeScreen(navigator)
        }
        scene("/detail") { backStackEntry ->
            DetailScreen(backStackEntry, navigator)
        }
    }
}
