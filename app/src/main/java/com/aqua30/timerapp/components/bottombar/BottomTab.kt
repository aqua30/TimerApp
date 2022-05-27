package com.aqua30.timerapp.components.bottombar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aqua30.timerapp.ui.theme.*

/**
 * Created by Saurabh
 */
@Composable
fun BottomTab(
    modifier: Modifier = Modifier,
    title: String,
    icon: ImageVector,
    isSelected: Boolean = false,
    onClick: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable { onClick(title) }
            .then(modifier),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier.fillMaxWidth()
                    .clip(RoundedCornerShape(50))
                    .background(
                        if (isSelected) BLUE_LIGHT
                        else GRAY_LIGHT
                    )
                    .padding(4.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    icon,
                    modifier = Modifier
                        .height(32.dp)
                        .padding(4.dp),
                    contentDescription = title,
                    tint = if (isSelected) BLUE_GLOSS else GRAY_TEXT
                )
            }
            Text(
                title,
                modifier = Modifier.padding(top = 4.dp),
                style = TextStyle(
                    color = GRAY_TEXT,
                    fontSize = 14.sp,
                )
            )
        }
    }
}

@Preview
@Composable
fun BottomTabPreview() {
    TimerAppTheme {
        BottomTab(
            modifier = Modifier,
            "Clock",
            Icons.Outlined.AccessTime,
            onClick = {}
        )
    }
}