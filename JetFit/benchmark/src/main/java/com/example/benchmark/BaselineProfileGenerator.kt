package com.example.benchmark

import android.os.Build
import android.view.KeyEvent
import androidx.annotation.RequiresApi
import androidx.benchmark.macro.junit4.BaselineProfileRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BaselineProfileGenerator {
    @RequiresApi(Build.VERSION_CODES.P)
    @get:Rule
    val baselineProfileRule = BaselineProfileRule()

    @RequiresApi(Build.VERSION_CODES.P)
    @Test
    fun generateBaseLineProfile() = baselineProfileRule.collect(
        packageName = "com.google.jetfit"
    ){
        startActivityAndWait()

        fun back() = device.pressBack()
        fun menu() = device.pressMenu()
        fun home() = device.pressHome()
        fun playPause() = device.pressKeyCode(KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE)

        // D-Pad Controls:
        fun left() = device.pressDPadLeft()
        fun right() = device.pressDPadRight()
        fun down() = device.pressDPadDown()
        fun up() = device.pressDPadUp()
        fun select() = device.pressDPadCenter()

    }
}