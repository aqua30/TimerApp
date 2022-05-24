package com.aqua30.timerapp.components.keypad

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aqua30.timerapp.domain.Keypad
import com.aqua30.timerapp.ui.theme.BLUE_LIGHT
import com.aqua30.timerapp.ui.theme.TimerAppTheme

/**
 * Created by Saurabh
 */
@Composable
fun TimerKeypadScreen(
    onKeyClick: (Keypad) -> Unit
) {

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            val modifier =  Modifier
                .width(96.dp)
                .height(96.dp)
            TimerNumKey(
                modifier = modifier,
                key = Keypad.Key1,
                onClick = onKeyClick
            )

            TimerNumKey(
                modifier = modifier,
                key = Keypad.Key2,
                onClick = onKeyClick
            )

            TimerNumKey(
                modifier = modifier,
                key = Keypad.Key3,
                onClick = onKeyClick
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            val modifier =  Modifier
                .width(96.dp)
                .height(96.dp)
            TimerNumKey(
                modifier = modifier,
                key = Keypad.Key4,
                onClick = onKeyClick
            )

            TimerNumKey(
                modifier = modifier,
                key = Keypad.Key5,
                onClick = onKeyClick
            )

            TimerNumKey(
                modifier = modifier,
                key = Keypad.Key6,
                onClick = onKeyClick
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            val modifier =  Modifier
                .width(96.dp)
                .height(96.dp)
            TimerNumKey(
                modifier = modifier,
                key = Keypad.Key7,
                onClick = onKeyClick
            )

            TimerNumKey(
                modifier = modifier,
                key = Keypad.Key8,
                onClick = onKeyClick
            )

            TimerNumKey(
                modifier = modifier,
                key = Keypad.Key9,
                onClick = onKeyClick
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            val modifier =  Modifier
                .width(96.dp)
                .height(96.dp)
            TimerNumKey(
                modifier = modifier,
                key = Keypad.Key00,
                onClick = onKeyClick
            )

            TimerNumKey(
                modifier = modifier,
                key = Keypad.Key0,
                onClick = onKeyClick
            )

            TimerNumKey(
                modifier = modifier,
                key = Keypad.KeyDelete,
                backgroundColor = BLUE_LIGHT,
                onClick = onKeyClick
            )
        }
    }
}

//@Preview
@Composable
fun TimerKeypadPreview() {
    TimerAppTheme {
        TimerKeypadScreen {}
    }
}