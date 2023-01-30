package com.example.signin.ui.compose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.signin.navigation.NavGraphs

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun AppContent(navHostController: NavHostController) {
    val materialBlue700 = Color(0xFF4321D2)
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    "SignIn Instant App Demo",
                    color = materialBlue700,
                )
            }, Modifier.background(materialBlue700)
            )
        },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)){
                NavGraphs(navHostController = navHostController)
            }
        }
    )
}
