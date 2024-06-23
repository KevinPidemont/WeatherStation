package com.electronicsample.myweatherstation.ui.page.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.electronicsample.myweatherstation.R
import com.electronicsample.myweatherstation.ui.theme.Spacings

// TODO centralize the color in their own files
val BackgroundColor: Color = Color(0xFF3A3A3A)
val ContentColor: Color = Color(0xFFFAFAFA)

@Composable
fun AudioRecordCard() {
    Card {
        Column(
            modifier = Modifier.padding(Spacings.MediumSpacing),
            verticalArrangement = Arrangement.spacedBy(Spacings.SmallSpacing)
        ) {
            Text(
                text = stringResource(
                    id = R.string.audio_record_card_title,
                    formatArgs = arrayOf(12, "12 / 04 / 2023 à 14 h27")
                ),
                fontWeight = FontWeight.Bold
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(Spacings.SmallSpacing)
            ) {
                IconButton(
                    onClick = { /*TODO*/ },
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = BackgroundColor,
                        contentColor = ContentColor
                    )
                ) {
                    Icon(imageVector = Icons.Default.PlayArrow, contentDescription = null)
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(4.dp)
                        .background(
                            color = BackgroundColor,
                            shape = RoundedCornerShape(2.dp)
                        )
                )

                // TODO replace this value by the real one
                Text(text = "0:32", color = BackgroundColor)
            }
        }
    }
}

@Preview
@Composable
private fun AudioRecordCardPreview() {
    AudioRecordCard()
}