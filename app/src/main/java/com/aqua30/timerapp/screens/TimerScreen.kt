package com.aqua30.timerapp.screens

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aqua30.timerapp.components.ScreenTitle
import com.aqua30.timerapp.components.bottombar.BottomBar
import com.aqua30.timerapp.domain.Keypad
import com.aqua30.timerapp.domain.TimerContent
import com.aqua30.timerapp.domain.UiEvent
import com.aqua30.timerapp.ui.theme.GRAY_BACKGROUND
import com.aqua30.timerapp.ui.theme.GRAY_LIGHT

/**
 * Created by Saurabh
 */
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun TimerScreen(
    timerViewModel: TimerViewModel = viewModel()
) {

    val timeState by remember {
        timerViewModel.timeState
    }
    val timerContent by remember {
        timerViewModel.timerContent
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(GRAY_BACKGROUND),
    ) {
        ScreenTitle(title = "Timer")
        Spacer(modifier = Modifier.height(34.dp))
        AnimatedContent(
            targetState = timerContent,
            transitionSpec = {
                if(targetState == TimerContent.SELECTION) {
                    slideInVertically { height -> height } + fadeIn() with
                            slideOutVertically { height -> -height } + fadeOut()
                } else {
                    slideInVertically { height -> -height } + fadeIn() with
                            slideOutVertically { height -> height } + fadeOut()
                }
            }
        ) {
            target ->
            if (target == TimerContent.SELECTION) {
                TimerSelectionScreen(
                    modifier = Modifier.fillMaxWidth(),
                    timeState = timeState,
                    onKeyClick = { key ->
                        timerViewModel.onEvent(
                            UiEvent.OnKeyPressed(key)
                        )
                    }
                )
            } else {
                TimerRunnerScreen(
                    modifier = Modifier.fillMaxWidth(),
                    onTimerStop = { key ->
                        timerViewModel.onEvent(
                            UiEvent.OnKeyPressed(key)
                        )
                    }
                )
            }
        }
        Box(modifier = Modifier
            .fillMaxHeight()
            .weight(1f),
            contentAlignment = Alignment.BottomCenter
        ) {
            BottomBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(GRAY_LIGHT),
                onTabClick = {
                    timerViewModel.onEvent(
                        UiEvent.OnKeyPressed(Keypad.KeyPlay)
                    )
                }
            )
        }
    }
}