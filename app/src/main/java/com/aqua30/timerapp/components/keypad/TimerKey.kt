package com.aqua30.timerapp.components.keypad

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Backspace
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aqua30.timerapp.domain.Keypad
import com.aqua30.timerapp.ui.theme.BLUE_GLOSS
import com.aqua30.timerapp.ui.theme.GRAY_LIGHT
import com.aqua30.timerapp.ui.theme.GRAY_TEXT

/**
 * Created by Saurabh
 */
@Composable
fun TimerNumKey(
    key: Keypad,
    modifier: Modifier = Modifier,
    backgroundColor: Color = GRAY_LIGHT,
    textColor: Color = GRAY_TEXT,
    onClick: (Keypad) -> Unit,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(100.dp))
            .background(backgroundColor)
            .clickable {
                onClick(key)
            }
            .then(modifier),
    ) {
        if (key.value == Keypad.KeyDelete.value) {
            Icon(
                Icons.Outlined.Backspace,
                modifier = Modifier.size(18.dp),
                contentDescription = "Delete",
                tint = BLUE_GLOSS
            )
        } else {
            Text(
                key.value,
                style = TextStyle(
                    color = textColor,
                    fontSize = 34.sp,
                ),
            )
        }
    }
}

@Preview
@Composable
fun TimerKeyPreview() {
    TimerNumKey(key = Keypad.Key1, onClick = {})
}