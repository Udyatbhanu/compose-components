package com.bhanu.baliyar.composecomponents.samples

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.bhanu.baliyar.composecomponents.samples.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
    currentRoute: String?,
    onBackClick: () -> Unit,
    startDestination: String = Screen.Home.route
) {
    TopAppBar(
        title = { Text(text = "AppBar") },

        navigationIcon = {
            if (currentRoute != null && currentRoute != startDestination) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.Default.ArrowBackIosNew,
                        contentDescription = "Back"
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}


@Preview(name = "TopAppBar - Start Destination (No Back)")
@Composable
fun CustomTopAppBarPreviewStart() {
    MaterialTheme {
        CustomTopAppBar(
            currentRoute = Screen.Home.route,
            onBackClick = {}
        )
    }
}

@Preview(name = "TopAppBar - Other Route (Back Visible)")
@Composable
fun CustomTopAppBarPreviewOther() {
    MaterialTheme {
        CustomTopAppBar(
            currentRoute = "details", // Not the start destination
            onBackClick = {}
        )
    }
}
