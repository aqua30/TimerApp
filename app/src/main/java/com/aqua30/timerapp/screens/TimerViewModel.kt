package com.aqua30.timerapp.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.aqua30.timerapp.domain.Keypad
import com.aqua30.timerapp.domain.TimerContent
import com.aqua30.timerapp.domain.UiEvent
import com.aqua30.timerapp.domain.model.TimeData
import com.aqua30.timerapp.domain.model.TimeUnit

/**
 * Created by Saurabh
 */
class TimerViewModel: ViewModel() {

    var timeState = mutableStateOf(TimeData())
    var timerContent = mutableStateOf(TimerContent.SELECTION)

    fun onEvent(event: UiEvent) {
        when(event) {
            is UiEvent.OnKeyPressed -> {
                onKeyPress(event.key)
            }
        }
    }

    private fun onKeyPress(key: Keypad) {
        when(key) {
            Keypad.KeyPlay -> {
                /* when play key is clicked */
                timerContent.value = TimerContent.RUNNER
            }
            Keypad.KeyStop -> {
                /* when stop key is clicked */
                timerContent.value = TimerContent.SELECTION
            }
            Keypad.KeyDelete -> {
                /* when delete key is clicked */
                if (timeState.value.isDataEmpty())
                    return
                deleteTime()
            }
            Keypad.Key00 -> {
                /* when double zero key is clicked */
                if (timeState.value.isDataEmpty()
                    || timeState.value.isHoursHalfFull()
                    || timeState.value.isDataFull()
                )
                    return
                addTime(Keypad.Key0.value)
                addTime(Keypad.Key0.value)
            }
            Keypad.Key0 -> {
                /* when zero key is clicked */
                if (timeState.value.isDataEmpty()
                    || timeState.value.isDataFull()
                )
                    return
                addTime(key.value)
            }
            else -> {
                /* when any num key is clicked */
                if (timeState.value.isDataFull())
                    return
                addTime(key.value)
            }
        }
    }

    private fun deleteTime() {
        val secs = TimeUnit(
            rightDigit = timeState.value.secs.leftDigit,
            leftDigit = timeState.value.mins.rightDigit,
        )
        val mins = TimeUnit(
            rightDigit = timeState.value.mins.leftDigit,
            leftDigit = timeState.value.hours.rightDigit,
        )
        val hours = TimeUnit(
            rightDigit = timeState.value.hours.leftDigit,
            leftDigit = 0,
        )
        timeState.value = timeState.value.copy(
            hours = hours,
            mins = mins,
            secs = secs
        )
    }

    private fun addTime(value: String) {
        val intValue = value.toInt()
        val hours = TimeUnit(
            leftDigit = timeState.value.hours.rightDigit,
            rightDigit = timeState.value.mins.leftDigit,
        )
        val mins = TimeUnit(
            leftDigit = timeState.value.mins.rightDigit,
            rightDigit = timeState.value.secs.leftDigit,
        )
        val secs = TimeUnit(
            leftDigit = timeState.value.secs.rightDigit,
            rightDigit = intValue,
        )
        timeState.value = timeState.value.copy(
            hours = hours,
            mins = mins,
            secs = secs
        )
    }
}