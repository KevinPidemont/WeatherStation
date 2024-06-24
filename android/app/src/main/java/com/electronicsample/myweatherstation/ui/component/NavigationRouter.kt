package com.electronicsample.myweatherstation.ui.component

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.electronicsample.myweatherstation.ui.page.arduinocontroller.ArduinoControllerPage
import com.electronicsample.myweatherstation.ui.page.home.HomePage
import com.electronicsample.myweatherstation.ui.page.log.LogPage

@Composable
fun NavigationRouter(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationDestination.Home.destination) {
        composable(route = NavigationDestination.Home.destination) {
            HomePage()
        }

        composable(route = NavigationDestination.ArduinoController.destination) {
            ArduinoControllerPage()
        }

        composable(route = NavigationDestination.Logs.destination) {
            LogPage()
        }
    }
}