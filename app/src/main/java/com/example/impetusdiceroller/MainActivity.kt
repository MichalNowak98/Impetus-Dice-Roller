package com.example.impetusdiceroller

import DisciplineScreenViewModel
import InitiativeScreenViewModel
import MeleeScreenViewModel
import RangeScreenViewModel
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.impetusdiceroller.model.ScreenType
import com.example.impetusdiceroller.model.TabBarItem
import com.example.impetusdiceroller.ui.theme.ImpetusDiceRollerTheme
import com.example.impetusdiceroller.view.DisciplineScreen
import com.example.impetusdiceroller.view.InitiativeScreen
import com.example.impetusdiceroller.view.MeleeScreen
import com.example.impetusdiceroller.view.RangeScreen
import com.example.impetusdiceroller.view.TabView

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImpetusDiceRollerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ImpetusDiceRollerApp()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ImpetusDiceRollerApp() {
    val navController = rememberNavController()
    val bottomBarTabs = createBottomBarTabs()
    Scaffold(bottomBar = { TabView(bottomBarTabs, navController) }) {
        NavHost(navController = navController, startDestination = bottomBarTabs.first().screenType.title) {
            bottomBarTabs.map { (screenType) ->
                composable(screenType.title) {
                    when (screenType) {
                        ScreenType.INITIATIVE -> InitiativeScreen(InitiativeScreenViewModel())
                        ScreenType.RANGE -> RangeScreen(RangeScreenViewModel())
                        ScreenType.MELEE -> MeleeScreen(MeleeScreenViewModel())
                        ScreenType.DISCIPLINE -> DisciplineScreen(DisciplineScreenViewModel())
                    }
                }
            }
        }
    }
}

@Composable
fun createBottomBarTabs(): List<TabBarItem> {
    return listOf(
        TabBarItem(
            screenType = ScreenType.INITIATIVE,
            selectedIcon = ImageVector.vectorResource(id = R.drawable.initiative_icon),
            unselectedIcon = ImageVector.vectorResource(id = R.drawable.initiative_icon),
        ),
        TabBarItem(
            screenType = ScreenType.RANGE,
            selectedIcon = ImageVector.vectorResource(id = R.drawable.range_icon),
            unselectedIcon = ImageVector.vectorResource(id = R.drawable.range_icon),
        ),
        TabBarItem(
            screenType = ScreenType.MELEE,
            selectedIcon = ImageVector.vectorResource(id = R.drawable.melee_icon),
            unselectedIcon = ImageVector.vectorResource(id = R.drawable.melee_icon),
        ),
        TabBarItem(
            screenType = ScreenType.DISCIPLINE,
            selectedIcon = ImageVector.vectorResource(id = R.drawable.discipline_icon),
            unselectedIcon = ImageVector.vectorResource(id = R.drawable.discipline_icon),
        ),
    )
}