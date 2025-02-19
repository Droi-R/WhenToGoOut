package com.whentogoout.study

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderPositions
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun studyPreView(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        DemoScreen()
    }
}

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

@Composable
fun DemoScreen() {
    var sliderPositions by remember { mutableStateOf(20f) }
    val handelPositionChange = { position: Float ->
        sliderPositions = position
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        DemoText("Slider Value: $sliderPositions", 20f)
        Spacer(modifier = Modifier.height(150.dp))
        DemoSlider(
            sliderPositions = sliderPositions,
            onPositionChange = handelPositionChange
        )
        Text(
            style = MaterialTheme.typography.bodyLarge,
            text = sliderPositions.toInt().toString()+"sp"
        )
    }

}
