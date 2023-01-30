package com.example.signin.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.signin.ui.compose.ComposeLogin
import com.example.signin.ui.compose.ComposeSign

@ExperimentalFoundationApi
@Composable
fun NavGraphs(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = NavRoute.Login.path
    ) {

        composable(
            route = NavRoute.Login.path
        ) {
            ComposeLogin(navController = navHostController)
        }

        composable(
            route = NavRoute.Sign.path
        ) {
            ComposeSign(navController = navHostController)
        }
    }
}