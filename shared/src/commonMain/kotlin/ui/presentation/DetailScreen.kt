import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dolarapp.ui.presentation.Background
import com.myapplication.common.MR
import dev.icerock.moko.resources.compose.stringResource
import moe.tlaster.precompose.navigation.BackStackEntry
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.query

@Composable
fun DetailScreen(backStackEntry: BackStackEntry, navigator: Navigator) {
    val compra = backStackEntry.query<String>("compra") ?: 0.0
    val venta = backStackEntry.query<String>("venta") ?: 0.0
    val fechaActualizacion = backStackEntry.query<String>("fechaActualizacion") ?: "Desconocido"
    val nombre = backStackEntry.query<String>("nombre") ?: "Desconocido"

    Box(
        modifier = Modifier
            .background(Background)
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
            ValueRow(stringResource(MR.strings.buy),compra.toString())
            ValueRow(stringResource(MR.strings.sell), venta.toString())
            ValueRow(stringResource(MR.strings.last_update), fechaActualizacion)
        }

        val paddingBottom = when (getPlatformName()) {
            "Desktop" -> 0.dp
            "Android" -> 20.dp
            else -> 40.dp
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(16.dp, bottom = paddingBottom),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                modifier = Modifier
                    .padding(1.dp)
                    .width(165.dp)
                    .height(40.dp),
                onClick = { }, colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0x33FF403B),
                )
            ) {
                Text(
                    text = stringResource(MR.strings.sell),
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFFFF403B),
                    )
                )
            }
            Button(
                modifier = Modifier
                    .padding(1.dp)
                    .width(165.dp)
                    .height(40.dp),
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF3A58E3)
                )
            ) {
                Text(
                    text = stringResource(MR.strings.buy),
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFFFFFFFF),
                    )
                )
            }
        }
    }
}
@Composable
fun ValueRow(value1: String, value: String) {
    Column {
        Row(
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = value1,
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF1E1F4B),
                )
            )

            Text(
                text = value,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF1E1F4B),
                    textAlign = TextAlign.Right,
                )
            )
        }
        Divider(
            modifier = Modifier.padding(horizontal = 24.dp)
        )
    }
}