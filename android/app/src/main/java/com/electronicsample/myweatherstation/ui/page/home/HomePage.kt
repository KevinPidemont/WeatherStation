package com.electronicsample.myweatherstation.ui.page.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.electronicsample.myweatherstation.ui.page.home.component.AudioRecordCard
import com.electronicsample.myweatherstation.ui.page.home.component.AudioRecordSection
import com.electronicsample.myweatherstation.ui.page.home.component.WeatherCard
import com.electronicsample.myweatherstation.ui.theme.Spacings

@Composable
fun HomePage() {
    LazyColumn(
        contentPadding = PaddingValues(Spacings.LargeSpacing),
        verticalArrangement = Arrangement.spacedBy(Spacings.SmallSpacing)
    ) {
        item {
            WeatherCard()
        }

        // Create a huge gap between the weather card and the audio records list
        item {
            Spacer(modifier = Modifier.height(Spacings.HugeSpacing - Spacings.SmallSpacing))
        }

        item {
            AudioRecordSection()
        }

        items(15) {
            AudioRecordCard()
        }
    }
}


@Preview
@Composable
private fun HomePagePreview() {
    HomePage()
}