package com.example.tpclock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tpclock.ui.theme.TpclockTheme

class MainActivity : ComponentActivity() {
    private val viewModel: ClockFaceViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TpclockTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TPClock(viewModel)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        viewModel.removeHandler()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TpclockTheme {
        TPClock(viewModel = viewModel())
    }
}