

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myapplication.common.MR
import dev.icerock.moko.resources.compose.stringResource

@Composable
fun AppBarHome() {
    val paddingTop = if (getPlatformName() == "Android") 5.dp else 35.dp
    val paddingBottom = if (getPlatformName() == "Android") 0.dp else 10.dp

    Column(Modifier.padding(start = 24.dp, top = paddingTop, bottom = paddingBottom)) {
        Text(
            text = stringResource(MR.strings.name),
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 32.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF1E1F4B),
                letterSpacing = 0.5.sp,
            )
        )

        Text(
            text = stringResource(MR.strings.welcome),
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF1E1F4B),
                letterSpacing = 0.5.sp,
            )
        )
    }
}

@Composable
fun ProfileImage() {
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .padding(horizontal = 25.dp, vertical = 35.dp)
            .fillMaxWidth() // Establece el tamaño de la caja al tamaño de la imagen
    ) {
        /*Image(
            painter = "https://media.licdn.com/dms/image/C4D03AQGZ8_6kVQ7LxA/profile-displayphoto-shrink_800_800/0/1661524113725?e=1705536000&v=beta&t=2IZMZB56oUXKN_yxgUk5cYmyD8EbDA1qU-88eNgqC7U",
            contentDescription = "Icono de dólar",
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp)) // Redondea las esquinas del borde
                .size(150.dp),
            contentScale = ContentScale.Fit
        )*/
    }
}


@Composable
fun CustomCard(
    text: String,
    onCardClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 20.dp)
    ) {
        Row(
            modifier = Modifier
                .clickable(onClick = onCardClick)
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Filled.AttachMoney,
                contentDescription = "Left Icon"
            )
            Spacer(modifier = Modifier.width(14.dp))
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = text,
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF1E1F4B),
                    )
                )
                Text(
                    text = stringResource(MR.strings.buy_now),
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF787A8D),
                    )
                )
            }
            Icon(
                imageVector = Icons.Filled.SwapHoriz,
                contentDescription = "Right Icon"
            )
        }
    }
}

