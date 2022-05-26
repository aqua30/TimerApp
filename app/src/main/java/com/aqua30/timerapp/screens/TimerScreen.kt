package com.aqua30.timerapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aqua30.timerapp.components.ScreenTitle
import com.aqua30.timerapp.components.bottombar.BottomBar
import com.aqua30.timerapp.domain.UiEvent
import com.aqua30.timerapp.ui.theme.GRAY_BACKGROUND
import com.aqua30.timerapp.ui.theme.TimerAppTheme

/**
 * Created by Saurabh
 */
@Composable
fun TimerScreen(
    timerViewModel: TimerViewModel = viewModel()
) {

    val timeState by remember {
        timerViewModel.timeState
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(GRAY_BACKGROUND),
    ) {
        ScreenTitle(title = "Timer")
        Spacer(modifier = Modifier.height(34.dp))
        TimerSelectionScreen(
            timeState = timeState,
            onKeyClick = { key ->
                timerViewModel.onEvent(
                    UiEvent.OnKeyPressed(key)
                )
            }
        )
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
            contentAlignment = Alignment.BottomCenter
        ) {
            BottomBar()
        }
    }
}

@Preview
@Composable
fun TimerPreview() {
    TimerAppTheme {
        TimerScreen()
    }
}