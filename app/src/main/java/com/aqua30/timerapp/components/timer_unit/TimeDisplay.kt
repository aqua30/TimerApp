package com.aqua30.timerapp.components.timer_unit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aqua30.timerapp.domain.model.TimeData
import com.aqua30.timerapp.ui.theme.TimerAppTheme

/**
 * Created by Saurabh
 */
@Composable
fun TimeDisplay(
    time: TimeData = TimeData()
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TimeUnit(
            time = time.hours,
            unit = "h"
        )

        TimeUnit(
            time = time.mins,
            unit = "m"
        )

        TimeUnit(
            time = time.secs,
            unit = "s"
        )
    }
}

@Preview
@Composable
fun TimeDisplayPreview() {
    TimerAppTheme {
        TimeDisplay()
    }
}