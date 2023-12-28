import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myapplication.common.MR
import dev.icerock.moko.resources.compose.stringResource
import moe.tlaster.precompose.navigation.BackStackEntry
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.query
import ui.presentation.components.Buttons
import ui.presentation.components.RowStats

@Composable
fun DetailScreen(backStackEntry: BackStackEntry, navigator: Navigator) {
    val compra = backStackEntry.query<String>("compra") ?: 0.0
    val venta = backStackEntry.query<String>("venta") ?: 0.0
    val fechaActualizacion = backStackEntry.query<String>("fechaActualizacion") ?: "Desconocido"
    val nombre = backStackEntry.query<String>("nombre") ?: "Desconocido"

    Box(
        modifier = Modifier
            .background(color = Color(0xFFF5F8FE))
            .fillMaxSize()
    ) {
        Column {
            DetailAppBar({ navigator.goBack() }, nombre)
            Spacer(Modifier.height(35.dp))
            Text(
                modifier = Modifier.padding(start = 24.dp),
                text = stringResource(MR.strings.stats),
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF1E1F4B),
                )
            )
            Spacer(Modifier.height(10.dp))
            RowStats(stringResource(MR.strings.buy), compra.toString())
            RowStats(stringResource(MR.strings.sell), venta.toString())
            RowStats(stringResource(MR.strings.last_update), fechaActualizacion)
            Buttons()
        }
    }
}

