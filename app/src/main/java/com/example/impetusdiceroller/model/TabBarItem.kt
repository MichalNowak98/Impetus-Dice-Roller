package com.example.impetusdiceroller.model

import androidx.compose.ui.graphics.vector.ImageVector

data class TabBarItem(
    val screenType: ScreenType,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)
