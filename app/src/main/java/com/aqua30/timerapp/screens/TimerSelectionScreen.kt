package com.aqua30.timerapp.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aqua30.timerapp.components.keypad.CircularKey
import com.aqua30.timerapp.components.keypad.TimerKeypadScreen
import com.aqua30.timerapp.components.timer_unit.TimeDisplay
import com.aqua30.timerapp.domain.Keypad
import com.aqua30.timerapp.domain.model.TimeData
import com.aqua30.timerapp.ui.theme.BLUE_GLOSS
import com.aqua30.timerapp.ui.theme.BLUE_LIGHT

/**
 * Created by Saurabh
 */
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun TimerSelectionScreen(
    modifier: Modifier,
    timeState: TimeData,
    onKeyClick: (Keypad) -> Unit
) {
    val isPlayButtonVisible = timeState.isDataEmpty().not()

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TimeDisplay(
            time = timeState,
        )
        Spacer(modifier = Modifier.height(24.dp))
        TimerKeypadScreen(
            onKeyClick = { key ->
                onKeyClick(key)
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        AnimatedVisibility(
            visible = isPlayButtonVisible,
            enter = scaleIn(),
            exit = scaleOut()
        ) {
            CircularKey(
                modifier = Modifier
                    .width(96.dp)
                    .height(96.dp),
                key = Keypad.KeyPlay,
                backgroundColor = BLUE_LIGHT,
                icon = Icons.Outlined.PlayArrow,
                textColor = BLUE_GLOSS,
                onClick = {
                    onKeyClick(it)
                }
            )
        }
    }
}