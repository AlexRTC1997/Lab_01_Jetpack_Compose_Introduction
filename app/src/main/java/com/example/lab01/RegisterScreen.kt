package com.example.lab01

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun RegisterScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "Register Form")
    }
}