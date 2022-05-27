package com.aqua30.timerapp.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PauseCircle
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aqua30.timerapp.components.keypad.CircularKey
import com.aqua30.timerapp.domain.Keypad
import com.aqua30.timerapp.ui.theme.BLUE_GLOSS
import com.aqua30.timerapp.ui.theme.BLUE_LIGHT
import kotlinx.coroutines.delay

/**
 * Created by Saurabh
 */
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun TimerRunnerScreen(
    modifier: Modifier,
    onTimerStop: (Keypad) -> Unit
) {

    var stopButtonVisible by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = true) {
        delay(300)
        stopButtonVisible = true
    }

    Column(
        modifier = modifier.padding(top = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(modifier = Modifier
            .width(300.dp)
            .height(300.dp)
            .background(Color.Yellow)
        )
        Spacer(modifier = Modifier.height(16.dp))
        AnimatedVisibility(
            visible = stopButtonVisible,
            enter = scaleIn(),
            exit = scaleOut(),
        ) {
            CircularKey(
                modifier = Modifier
                    .width(96.dp)
                    .height(96.dp),
                key = Keypad.KeyStop,
                backgroundColor = BLUE_LIGHT,
                icon = Icons.Outlined.PauseCircle,
                textColor = BLUE_GLOSS,
                onClick = {
                    onTimerStop(it)
                }
            )
        }
    }
}

//@Preview
@Composable
fun TimerRunnerScreenPreview() {
//    TimerRunnerScreen()
}