package com.bhanu.baliyar.composecomponents.samples.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bhanu.baliyar.composecomponents.samples.CustomCard
import com.bhanu.baliyar.composecomponents.samples.ImageCard
import com.bhanu.baliyar.composecomponents.samples.SearchTextField


@Composable
fun ListScreen(
    modifier: Modifier = Modifier,
    onItemClick: () -> Unit
) {
    val queryState = remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        SearchTextField(
            query = queryState.value,
            onQueryChange = { queryState.value = it },
            onSearch = {
                // Perform search action or log for now
                println("Search triggered: ${queryState.value}")
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = "Search components..."
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text("Hello, Jetpack Compose!")
        Spacer(modifier = Modifier.height(16.dp))
        CustomCard(title = "A title", description = "A desc", onButtonClick = onItemClick)
        CustomCard(title = "A title", description = "A desc", onButtonClick = onItemClick)
        CustomCard(title = "A title", description = "A desc", onButtonClick = onItemClick)
        ImageCard(
            title = "Something",
            description = "None",
            imageUrl = "https://images.pexels.com/photos/31112548/pexels-photo-31112548/free-photo-of-skier-navigates-snowy-mountain-terrain.jpeg",
            modifier = modifier
        )
    }
}