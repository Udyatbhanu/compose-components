package com.bhanu.baliyar.composecomponents

import app.cash.paparazzi.Paparazzi
import com.bhanu.baliyar.composecomponents.samples.DashBoardScreen
import com.bhanu.baliyar.composecomponents.ui.theme.ComposeComponentsTheme
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import java.io.File

class DashBoardScreenScreenshotTest {


    companion object {
        @JvmStatic
        @BeforeClass
        fun setup() {
            // Create an absolute path for the output directory
            val outputDir = File(System.getProperty("user.dir"), "build/reports/paparazzi").absolutePath
            System.setProperty("paparazzi.outputDir", outputDir)
        }
    }

    @get:Rule
    val paparazzi = Paparazzi()

    @Test
    fun dashBoardScreenScreenshotTest() {
        paparazzi.snapshot {
            // Wrap your composable with the app's theme for correct styling.
            ComposeComponentsTheme {
                DashBoardScreen()
            }
        }
    }
}