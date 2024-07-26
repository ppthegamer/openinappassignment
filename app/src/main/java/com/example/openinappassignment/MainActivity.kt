package com.example.openinappassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mathongoandroiassignmenrt.navigation.BottomNavigationModel
import com.example.openinappassignment.customcomponents.CustomText24Weight600
import com.example.openinappassignment.repository.DashboardRepository
import com.example.openinappassignment.screens.DashboardScreen
import com.example.openinappassignment.ui.theme.OpenInAppAssignmentTheme
import com.example.openinappassignment.viewmodels.DashboardViewModel

class MainActivity : ComponentActivity() {
    val dashboardViewModel: DashboardViewModel by viewModels {
        MainViewModelFactory(
            DashboardRepository()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OpenInAppAssignmentTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    MainScreen()
                }
            }
        }
    }


    @Composable

    fun MainScreen() {
        val navController = rememberNavController()
        val bottomBarNavScreen =
            listOf(
                BottomNavigationModel.LinksScreen,
                BottomNavigationModel.CoursesScreen,
                BottomNavigationModel.CampaignsScreen,
                BottomNavigationModel.ProfileScreen
            )
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                NavigationBar(containerColor = Color.White) {
                    bottomBarNavScreen.forEach { screenItems ->
                        NavigationBarItem(colors = NavigationBarItemDefaults.colors(
                            indicatorColor = MaterialTheme.colorScheme.primary,
                            selectedTextColor = MaterialTheme.colorScheme.primary,
                            selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                            unselectedTextColor = MaterialTheme.colorScheme.secondary,
                            unselectedIconColor = MaterialTheme.colorScheme.secondary,
                        ),
                            selected = currentDestination?.hierarchy?.any { it.route == screenItems.route } == true,
                            onClick = {
                                navController.navigate(screenItems.route) {
                                    navController.graph.findStartDestination().route?.let {
                                        popUpTo(it) {
                                            saveState = true
                                        }

                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            icon = {
                                Icon(
                                    imageVector = screenItems.icon,
                                    contentDescription = "icon"
                                )
                            },
                            label = {
                                Text(
                                    text = screenItems.title
                                )
                            })
                    }
                }
            },

            ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = BottomNavigationModel.LinksScreen.route,
                Modifier.padding(innerPadding)
            ) {
                composable(BottomNavigationModel.LinksScreen.route) { DashboardScreen(viewModel = dashboardViewModel) }
                composable(BottomNavigationModel.CoursesScreen.route) { CoursesScreen() }
                composable(BottomNavigationModel.CampaignsScreen.route) { CampaignsScreen() }
                composable(BottomNavigationModel.ProfileScreen.route) { ProfileScreen() }
            }
        }
    }

    @Composable
    fun CoursesScreen() {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CustomText24Weight600(text = "CoursesScreen")
        }
    }

    @Composable
    fun CampaignsScreen() {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CustomText24Weight600(text = "CampaignsScreen")
        }
    }

    @Composable
    fun ProfileScreen() {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CustomText24Weight600(text = "ProfileScreen")
        }
    }

}

