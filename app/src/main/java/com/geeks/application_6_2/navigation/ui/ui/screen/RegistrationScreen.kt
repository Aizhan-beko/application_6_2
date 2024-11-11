package com.geeks.application_6_2.navigation.ui.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.geeks.application_6_2.navigation.navigation.nav_graph.OnboardingScreen

@Composable
fun RegistrationScreen(navController: NavController) {
    var userName by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Please enter your name!",
                color = Color.DarkGray,
                fontSize = 25.sp,
                fontWeight = FontWeight.ExtraBold)
            OutlinedTextField(
                value = userName,
                onValueChange = { userName = it },
                label = { Text(text = "Username:") }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                if (userName.isNotEmpty()) {
                    navController.navigate(OnboardingScreen.Confirmation.createRoute(userName))
                }
            }) {
                Text(text = "Navigate to Confirmation screen.",
                    color = Color.LightGray,
                    fontSize = 20.sp)
            }
        }
    }
}