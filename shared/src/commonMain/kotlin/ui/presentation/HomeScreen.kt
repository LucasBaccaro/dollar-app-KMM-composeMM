package com.dolarapp.ui.presentation

import AppBarHome
import CustomCard
import ProfileImage
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
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
import com.myapplication.common.MR
import dev.icerock.moko.resources.compose.stringResource
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle
import moe.tlaster.precompose.koin.koinViewModel
import moe.tlaster.precompose.navigation.Navigator
import ui.DollarViewModel
import ui.presentation.components.Center

// Definición de la paleta de colores en hexadecimales
val VerdeClaro = Color(0xFFA5D6A7)
val VerdeOscuro = Color(0xFF2E7D32)
val VerdeFondo = Color(0xFFE8F5E9)
val BlancoTexto = Color(0xFFFFFFFF)
val NegroTexto = Color(0xFF000000)
val Background = Color(0xFFF5F8FE)

@Composable
fun HomeScreen(navigator: Navigator) {
    val viewModel = koinViewModel(DollarViewModel::class)
    val state = viewModel.state.collectAsStateWithLifecycle().value

    Column(Modifier.fillMaxSize().background(Color(0xFFF5F8FE))) {
        AppBarHome()
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            when {
                state.isLoading -> {
                    Center {
                        CircularProgressIndicator(color = VerdeClaro)
                    }
                }

                state.isFailure -> {
                    Center {
                        Text(text = stringResource(MR.strings.error))
                    }
                }

                else -> {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.Center)
                    ) {
                        item {
                            ProfileImage()
                            TextRow()
                        }
                        items(state.data) { dolar ->
                            CustomCard(
                                text = dolar.nombre.uppercase(),
                                onCardClick = {
                                    navigator.navigate("/detail?casa=${dolar.casa}&compra=${dolar.compra}&venta=${dolar.venta}&moneda=${dolar.moneda}&nombre=${dolar.nombre}&fechaActualizacion=${dolar.fechaActualizacion}")
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TextRow() {
    Row(
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(MR.strings.back),
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 32.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF1E1F4B),
                letterSpacing = 0.5.sp,
            )
        )

        Text(
            text = stringResource(MR.strings.more),
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF4766F9),
                textAlign = TextAlign.Right,
                letterSpacing = 0.24.sp,
            )
        )
    }
}





