package com.example.tpclock

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date
import java.util.Locale


class ClockFaceViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ClockFaceState())
    val uiState: StateFlow<ClockFaceState> = _uiState.asStateFlow()

    init {
        updateClock()
    }

    fun updateClock() {
        _uiState.update {
            val time = Calendar.getInstance().time
            val formatter = SimpleDateFormat("HH:mm:ss", Locale.US)
            it.copy(currentTime = formatter.format(time))
        }
    }
}

data class ClockFaceState(
    val currentTime: String = ""
)