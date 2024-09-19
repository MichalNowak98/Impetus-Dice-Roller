package com.example.impetusdiceroller.view

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.impetusdiceroller.model.TabBarItem

@Composable
fun TabView(tabBarItems: List<TabBarItem>, navController: NavController) {
    var selectedTabIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    NavigationBar {
        tabBarItems.forEachIndexed { index, tabBarItem ->
            NavigationBarItem(
                selected = selectedTabIndex == index,
                onClick = {
                    selectedTabIndex = index
                    navController.navigate(tabBarItem.screenType.title)
                },
                icon = {
                    Icon(
                        imageVector = if (selectedTabIndex == index) {
                            tabBarItem.selectedIcon
                        } else {
                            tabBarItem.unselectedIcon
                        },
                        contentDescription = tabBarItem.screenType.title,
                        modifier = Modifier.size(25.dp)
                    )
                },
                label = { Text(tabBarItem.screenType.title) })
        }
    }
}
