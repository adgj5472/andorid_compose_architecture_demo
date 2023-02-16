package com.onion.signin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.onion.signin.navigation.NavigationComponent
import com.onion.signin.ui.theme.SigninTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navHostController: NavHostController

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            packageManager.isInstantApp
//        } else {
//
//        }
        setContent {
            navHostController = rememberNavController()
            SigninTheme {
                val materialBlue700 = Color(0xFF4321D2)
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    "SignIn Instant App Demo",
                                    color = materialBlue700,
                                )
                            },
                            modifier = Modifier.background(materialBlue700),
                            navigationIcon = {
                                IconButton(onClick = {
                                    navHostController.navigateUp()
                                }) {
                                    Icon(Icons.Filled.ArrowBack, null)
                                }
                            },
                            actions = {
                                IconButton(onClick = {/* Do Something*/ }) {
                                    Icon(Icons.Filled.Share, null)
                                }
                                IconButton(onClick = {/* Do Something*/ }) {
                                    Icon(Icons.Filled.Settings, null)
                                }
                            }
                        )
                    },
                    content = { padding ->
                        NavigationComponent(navHostController, padding)
                    }
                )
            }
        }
    }

}