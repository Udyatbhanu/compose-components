package com.bhanu.baliyar.composecomponents

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.bhanu.baliyar.composecomponents.samples.CustomCard
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class CustomCardTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun customCard_displaysContentCorrectly() {
        // Set the content to test the CustomCard
        composeTestRule.setContent {
            MaterialTheme {
                CustomCard(
                    title = "Test Title",
                    description = "Test Description",
                    onButtonClick = {}
                )
            }
        }

        // Verify that the title, description, and button are displayed
        composeTestRule.onNodeWithText("Test Title").assertExists()
        composeTestRule.onNodeWithText("Test Description").assertExists()
        composeTestRule.onNodeWithText("Action").assertExists()
    }

    @Test
    fun customCard_buttonClick_triggersOnClick() {
        var isClicked = false

        // Set the content with a click handler that toggles isClicked
        composeTestRule.setContent {
            MaterialTheme {
                CustomCard(
                    title = "Test Title",
                    description = "Test Description",
                    onButtonClick = { isClicked = true }
                )
            }
        }

        // Find and click the button
        composeTestRule.onNodeWithText("Action").performClick()

        // Verify that the onClick lambda was triggered
        composeTestRule.runOnIdle {
            assertTrue("CustomCard onButtonClick should have been triggered", isClicked)
        }
    }
}