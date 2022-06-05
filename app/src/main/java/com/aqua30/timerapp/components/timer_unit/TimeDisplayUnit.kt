package com.aqua30.timerapp.components.timer_unit

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.aqua30.timerapp.domain.model.TimeUnit
import com.aqua30.timerapp.ui.theme.GRAY_TEXT
import com.aqua30.timerapp.ui.theme.TimerAppTheme

/**
 * Created by Saurabh
 */
@Composable
fun TimeDisplayUnit(
    time: TimeUnit = TimeUnit(),
    unit: String,
    textColor: Color = GRAY_TEXT
) {

    Row(
        modifier = Modifier.wrapContentSize(),
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text = "${time.leftDigit}",
            modifier = Modifier.alignByBaseline(),
            style = TextStyle(
                fontSize = 65.sp,
                fontWeight = FontWeight.Medium,
                color = textColor,
            )
        )
        Text(
            text = "${time.rightDigit}",
            modifier = Modifier.alignByBaseline(),
            style = TextStyle(
                fontSize = 65.sp,
                fontWeight = FontWeight.Medium,
                color = textColor,
            ),
        )
        Text(
            text = unit,
            modifier = Modifier.alignByBaseline(),
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
                color = textColor,
            ),
        )
    }
}

@Preview
@Composable
fun TimerUnitPreview() {
    TimerAppTheme {
        TimeDisplayUnit(time = TimeUnit(), unit = "s")
    }
}