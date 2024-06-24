package com.electronicsample.myweatherstation.ui.component

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.electronicsample.myweatherstation.R

enum class NavigationDestination(val destination: String) {
    Home(destination = "home"),
    ArduinoController(destination = "arduino_controller"),
    Logs(destination = "logs")
}

@Composable
fun WeatherStationApp() {
    val navController = rememberNavController()

    // Helper method for navigating
    fun navigateTo(destination: NavigationDestination) {
        navController.navigate(destination.destination) {
            launchSingleTop = true
            restoreState = true
        }
    }

    val currentDestination by navController.currentBackStackEntryAsState()
    val currentRoute = currentDestination?.destination?.route

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = currentRoute == NavigationDestination.Home.destination,
                    onClick = {
                        navigateTo(NavigationDestination.Home)
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(text = stringResource(id = R.string.home))
                    }
                )

                NavigationBarItem(
                    selected = currentRoute == NavigationDestination.ArduinoController.destination,
                    onClick = {
                        navigateTo(NavigationDestination.ArduinoController)
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_settings_remote),
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(text = stringResource(id = R.string.communication))
                    }
                )

                NavigationBarItem(
                    selected = currentRoute == NavigationDestination.Logs.destination,
                    onClick = {
                        navigateTo(NavigationDestination.Logs)
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_browse_activity),
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(text = stringResource(id = R.string.logs))
                    }
                )
            }
        }
    ) { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {
            NavigationRouter(navController = navController)
        }
    }
}

@Preview
@Composable
private fun WeatherStationAppPreview() {
    WeatherStationApp()
}