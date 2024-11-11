package com.geeks.application_6_2.navigation.ui.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.geeks.application_6_2.navigation.navigation.nav_graph.OnboardingApp
import com.geeks.application_6_2.navigation.ui.ui.theme.Application_6_2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Application_6_2Theme {
                OnboardingApp()
            }
        }
    }
}