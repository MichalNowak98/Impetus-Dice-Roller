package com.example.impetusdiceroller.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun <T : Enum<T>> VerticalPicker(items: Array<T>, label: String, selectedValue: T,
                                 onItemSelected: (T) -> Unit) {
    Column {
        Text(
            text = "$label: ${selectedValue.name}",
            fontSize = 20.sp,
        )
        items.map { item ->
            Text(
                text = item.name,
                fontSize = 24.sp,
                modifier = Modifier
                    .clickable {
                        onItemSelected(item)
                    }
            )
        }
    }
}