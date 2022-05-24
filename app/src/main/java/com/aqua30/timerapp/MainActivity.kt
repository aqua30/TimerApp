package com.aqua30.timerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.aqua30.timerapp.screens.TimerScreen
import com.aqua30.timerapp.ui.theme.TimerAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TimerAppTheme {
                TimerScreen()
            }
        }
    }
}