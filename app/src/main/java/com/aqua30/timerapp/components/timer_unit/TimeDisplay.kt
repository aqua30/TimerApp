package com.aqua30.timerapp.components.timer_unit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aqua30.timerapp.domain.model.TimeData
import com.aqua30.timerapp.ui.theme.BLUE_LIGHT
import com.aqua30.timerapp.ui.theme.GRAY_TEXT
import com.aqua30.timerapp.ui.theme.TimerAppTheme

/**
 * Created by Saurabh
 */
@Composable
fun TimeDisplay(
    time: TimeData = TimeData(),
) {

    val timeUnitColor  = if (time.isDataEmpty()) GRAY_TEXT else BLUE_LIGHT

    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TimeDisplayUnit(
            time = time.hours,
            unit = "h",
            textColor = timeUnitColor
        )

        TimeDisplayUnit(
            time = time.mins,
            unit = "m",
            textColor = timeUnitColor
        )

        TimeDisplayUnit(
            time = time.secs,
            unit = "s",
            textColor = timeUnitColor
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