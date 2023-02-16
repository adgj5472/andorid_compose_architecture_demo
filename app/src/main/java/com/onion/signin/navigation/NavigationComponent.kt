package com.onion.signin.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.onion.signin.ui.compose.LoginRoute
import com.onion.signin.ui.compose.SignRoute
import com.onion.signin.ui.compose.WebViewClientRoute

@Composable
fun NavigationComponent(navHostController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        navController = navHostController,
        startDestination = LoginRoute.route,
        modifier = Modifier.padding(paddingValues)
    ) {
        LoginRoute.composable(this, navHostController)
        SignRoute.composable(this, navHostController)
        WebViewClientRoute.composable(this, navHostController)
    }
}