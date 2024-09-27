package com.example.impetusdiceroller.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun Dice(value: Int) {
    val label = when(value) {
        1 -> "⚀"
        2 -> "⚁"
        3 -> "⚂"
        4 -> "⚃"
        5 -> "⚄"
        6 -> "⚅"
        else -> "error"
    }
    return Text(label)
}