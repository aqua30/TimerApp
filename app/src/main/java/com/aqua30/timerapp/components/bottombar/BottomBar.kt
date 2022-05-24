package com.aqua30.timerapp.components.bottombar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aqua30.timerapp.ui.theme.GRAY_LIGHT
import com.aqua30.timerapp.ui.theme.TimerAppTheme

/**
 * Created by Saurabh
 */
@Composable
fun BottomBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(GRAY_LIGHT),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val modifier = Modifier.weight(1f)
        BottomTab(
            modifier = modifier,
            title = "Alarm",
            icon = Icons.Outlined.Alarm,
            onClick = {}
        )
        BottomTab(
            modifier = modifier,
            title = "Clock",
            icon = Icons.Outlined.AccessTime,
            onClick = {}
        )
        BottomTab(
            modifier = modifier,
            title = "Timer",
            icon = Icons.Outlined.HourglassBottom,
            isSelected = true,
            onClick = {}
        )
        BottomTab(
            modifier = modifier,
            title = "Stopwatch",
            icon = Icons.Outlined.Timer,
            onClick = {}
        )
        BottomTab(
            modifier = modifier,
            title = "Bedtime",
            icon = Icons.Outlined.AirlineSeatIndividualSuite,
            onClick = {}
        )
    }
}

@Preview
@Composable
fun BottomBarPreview() {
    TimerAppTheme {
        BottomBar()
    }
}