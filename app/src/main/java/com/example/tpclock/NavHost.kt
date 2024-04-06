package com.example.tpclock

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "clock",
    viewModel: ClockFaceViewModel
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
    ) {

        composable(Destination.DIGITAL.name) {
            Clock(
                viewModel = viewModel
            )
        }

        composable(Destination.ALARM.name) {
//            DigitalClock()
        }
    }
}