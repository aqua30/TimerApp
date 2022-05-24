package com.aqua30.timerapp.domain

/**
 * Created by Saurabh
 */
sealed class UiEvent {
    data class OnKeyPressed(val key: Keypad): UiEvent()
}
