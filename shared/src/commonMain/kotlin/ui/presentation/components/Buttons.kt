package ui.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import getPlatformName
@Composable
fun Buttons() {
    val paddingBottom = when (getPlatformName()) {
        "Desktop" -> 10.dp
        "Android" -> 20.dp
        else -> 40.dp
    }
    Box(modifier = Modifier
        .background(color = Color(0xFFF5F8FE))
        .fillMaxSize()) {
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