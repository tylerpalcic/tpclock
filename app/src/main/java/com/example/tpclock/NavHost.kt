package com.example.tpclock

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
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
//        val viewModel: ClockFaceViewModel = viewModel()

        composable(Destination.ANALOG.name) {
            AnalogClock(
                viewModel = viewModel,
                buttonClick = {
                    viewModel.updateClock()
                }
            )
        }

        composable(Destination.DIGITAL.name) {
//            DigitalClock()
        }
    }
}