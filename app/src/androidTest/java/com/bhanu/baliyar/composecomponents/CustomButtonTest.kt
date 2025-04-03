package com.bhanu.baliyar.composecomponents

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.bhanu.baliyar.composecomponents.samples.CustomButton
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class CustomButtonTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun customButton_click_triggersOnClick() {
        // This flag will be updated when the button is clicked
        var isClicked = false

        // Set the composable content for testing
        composeTestRule.setContent {
            MaterialTheme {
                CustomButton(
                    text = "Click Me",
                    onClick = { isClicked = true }
                )
            }
        }

        // Verify that the button with text "Click Me" exists
        composeTestRule.onNodeWithText("Click Me").assertExists()

        // Perform a click on the button
        composeTestRule.onNodeWithText("Click Me").performClick()

        // Assert that the onClick lambda was triggered
        composeTestRule.runOnIdle {
            assertTrue("CustomButton onClick should have been triggered", isClicked)
        }
    }
}