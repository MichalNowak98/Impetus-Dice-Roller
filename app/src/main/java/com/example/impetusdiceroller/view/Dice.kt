package com.example.impetusdiceroller.view

import androidx.compose.runtime.Composable

@Composable
fun Dice(value: Int, size: Int = 30) {
    val assetName = when(value) {
        1 -> "dice1.png"
        2 -> "dice2.png"
        3 -> "dice3.png"
        4 -> "dice4.png"
        5 -> "dice5.png"
        6 -> "dice6.png"
        else -> "error"
    }
    return ImageFromAssets(assetName, size)
}
