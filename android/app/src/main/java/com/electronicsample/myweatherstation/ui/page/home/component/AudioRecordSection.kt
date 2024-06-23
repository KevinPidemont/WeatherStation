package com.electronicsample.myweatherstation.ui.page.home.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.electronicsample.myweatherstation.R

@Composable
fun AudioRecordSection() {
    Text(
        text = stringResource(id = R.string.audio_records),
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF3A3A3A)
    )
}

@Preview(showBackground = true)
@Composable
private fun AudioRecordSectionPreview() {
    AudioRecordSection()
}