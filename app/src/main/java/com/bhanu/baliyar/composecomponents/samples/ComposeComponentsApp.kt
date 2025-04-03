package com.bhanu.baliyar.composecomponents.samples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposeComponentsApp(modifier: Modifier = Modifier) {
    // Outer Scaffold with a top bar and content area.
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { CustomTopAppBar() },
        content = { innerPadding ->
            // The content area is padded to avoid overlap with the top app bar.
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(innerPadding) // Adjusts for top bar
                    .padding(16.dp)        // Additional internal spacing
            ) {
                // Display the dashboard screen content.
                DashBoardScreen()
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar() {
    TopAppBar(
        title = { Text(text = "AppBar") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}




