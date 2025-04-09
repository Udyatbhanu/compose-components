package com.bhanu.baliyar.composecomponents.samples

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Scaffold

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
import com.bhanu.baliyar.composecomponents.samples.navigation.AppNav
import com.bhanu.baliyar.composecomponents.samples.screens.ecommerce.ProductScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposeComponentsApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

//    AppNav(navController = navController, modifier = modifier.padding(innerPadding))
//    ProductScreen(navController)
    // Outer Scaffold with a top bar and content area.
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CustomTopAppBar(
                currentRoute = currentRoute,
                onBackClick = { navController.popBackStack() })
        },
        content = { innerPadding ->
            AppNav(navController = navController, modifier = modifier.padding(innerPadding))
        }
    )
}





