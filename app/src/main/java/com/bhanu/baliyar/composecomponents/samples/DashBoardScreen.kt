package com.bhanu.baliyar.composecomponents.samples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DashBoardScreen() {
    val queryState = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        SearchTextField(
            query = queryState.value,
            onQueryChange = { queryState.value = it }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("Hello, Jetpack Compose!")
        Spacer(modifier = Modifier.height(16.dp))
        CustomCard(title = "A title", description = "A desc", onButtonClick = {})
        CustomCard(title = "A title", description = "A desc", onButtonClick = {})
        CustomCard(title = "A title", description = "A desc", onButtonClick = {})
    }
}