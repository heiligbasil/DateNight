package com.heiligbasil.datenight

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.heiligbasil.datenight.ui.theme.DateNightTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DateNightTheme(darkTheme = true) {
                val navHostController: NavHostController = rememberNavController()
                ScreensNavigation(navHostController = navHostController)
            }
        }
    }
}
