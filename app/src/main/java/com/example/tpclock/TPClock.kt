package com.example.tpclock

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@Composable
fun TPClock(viewModel: ClockFaceViewModel) {
    val navController = rememberNavController()
    AppNavHost(navController = navController, startDestination = Destination.DIGITAL.name, viewModel = viewModel)
}

enum class Destination {
    DIGITAL,
    ALARM
}