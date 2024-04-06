package com.example.tpclock

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class ClockFaceViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ClockFaceState())
    val uiState: StateFlow<ClockFaceState> = _uiState.asStateFlow()

    private val handler = Handler(Looper.getMainLooper())
    private var updateTimeRunnable: Runnable

    init {
        updateClock()
        updateTimeRunnable = object : Runnable {
            override fun run() {
                updateClock()
                handler.postDelayed(this, 1000)
            }
        }

        handler.post(updateTimeRunnable)
    }

    fun updateClock() {
        _uiState.update {
            val time = Calendar.getInstance().time
            val formatter = SimpleDateFormat("HH:mm:ss", Locale.US)
            it.copy(currentTime = formatter.format(time))
        }
    }

    fun removeHandler() {
        handler.removeCallbacks(updateTimeRunnable)
    }
}

data class ClockFaceState(
    val currentTime: String = ""
)