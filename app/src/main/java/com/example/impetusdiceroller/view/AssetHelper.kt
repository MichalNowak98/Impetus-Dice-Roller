package com.example.impetusdiceroller.view

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun ImageFromAssets(assetName: String, size: Int) {
    val bitmap = LocalContext.current.assets.open(assetName).use { inputStream ->
            BitmapFactory.decodeStream(inputStream)
        }

    return Image(
        bitmap = bitmap.asImageBitmap(),
        contentDescription = "Image from assets",
        modifier = androidx.compose.ui.Modifier.size(size.dp)
    )
}
