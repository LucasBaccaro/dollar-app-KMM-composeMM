import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dolarapp.ui.presentation.Background
import com.myapplication.common.MR
import dev.icerock.moko.resources.compose.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailAppBar(onClick: () -> Unit, title: String) {
    val paddingTop = if (getPlatformName() == "Android") 5.dp else 35.dp
    Box(modifier = Modifier.padding(top = paddingTop)) {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(Background),
            title = {
                Text(
                    text = title,
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 32.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF1E1F4B),
                        letterSpacing = 0.5.sp,
                    )
                )
            },
            navigationIcon = {
                IconButton(onClick = { onClick() }) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = "Atrás",
                        modifier = Modifier.size(25.dp)
                    )
                }
            },
            actions = {
                Image(painter = painterResource(MR.images.profile), contentDescription = null,modifier = Modifier
                    .clip(CircleShape)
                    .size(40.dp),
                    contentScale = ContentScale.Fit)
            },
        )
    }
}