package com.example.tpclock

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AnalogClock(
    modifier: Modifier = Modifier,
    viewModel: ClockFaceViewModel = viewModel(),
    buttonClick: () -> Unit
) {
    val clockFaceState by viewModel.uiState.collectAsState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Red),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = clockFaceState.currentTime,
                    fontSize = 28.sp,
                    maxLines = 1
                )
            }
            Button(
                onClick = buttonClick,
            ) {
                Text(text = "Update time")
            }
        }
    }
}

@Preview
@Composable
fun AnalogClockPreview() {
    AnalogClock(
        viewModel = viewModel(),
        buttonClick = {}
    )
}