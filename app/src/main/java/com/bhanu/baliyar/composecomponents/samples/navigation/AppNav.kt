package com.bhanu.baliyar.composecomponents.samples.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bhanu.baliyar.composecomponents.samples.screens.DetailsScreen
import com.bhanu.baliyar.composecomponents.samples.screens.HomeScreen
import com.bhanu.baliyar.composecomponents.samples.screens.ListScreen
import com.bhanu.baliyar.composecomponents.samples.screens.ecommerce.ProductScreen


sealed class Screen(val route: String) {
    object Home : Screen("home")
    object List : Screen("list")
    object Details : Screen("details")
    object Products : Screen("products")
}

@Composable
fun AppNav(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                navController = navController
            )
        }
        composable(Screen.Products.route) {
            ProductScreen(
                navController = navController
            )
        }
        composable(Screen.List.route) {
            ListScreen(
                onItemClick = {
                    navController.navigate(Screen.Details.route)
                }
            )
        }

        composable(Screen.Details.route) {
            DetailsScreen(onBack = {
                navController.popBackStack()
            })
        }
    }
}