package com.electronicsample.myweatherstation.ui.page.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.electronicsample.myweatherstation.R
import com.electronicsample.myweatherstation.ui.theme.Spacings

@Composable
fun WeatherCard() {
    Card {
        Column(modifier = Modifier.padding(Spacings.MediumSpacing)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "20°C", fontSize = 50.sp)

                Column {
                    Text(
                        text = stringResource(
                            id = R.string.humidity_level,
                            formatArgs = arrayOf(45)
                        ),
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = stringResource(
                            id = R.string.pressure_level,
                            formatArgs = arrayOf(1137)
                        ),
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
            Spacer(modifier = Modifier.height(Spacings.SmallSpacing))
            Text(
                text = stringResource(
                    id = R.string.last_refresh,
                    formatArgs = arrayOf("Le 12/06/2024 à 10h37")
                ),
                fontStyle = FontStyle.Italic
            )
        }
    }
}

@Preview
@Composable
private fun WeatherCardPreview() {
    WeatherCard()
}