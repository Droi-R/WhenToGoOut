package com.whentogoout.study

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderPositions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DemoText(message: String, fontSize: Float) {
    Text(text = message, fontSize = fontSize.sp, fontWeight = FontWeight.Bold, color = Color.Black)
}

@Composable
fun DemoSlider(sliderPositions: Float, onPositionChange: (Float) -> Unit) {
    Slider(
        modifier = Modifier.padding(10.dp),
        valueRange = 20f..40f,
        value = sliderPositions,
        onValueChange = onPositionChange,
    )
}
