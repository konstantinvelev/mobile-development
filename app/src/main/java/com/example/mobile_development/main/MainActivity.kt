@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.mobile_development.main

import CustomTopAppBar
import HomeScreen
import LoginScreen
import com.example.mobile_development.ui.productDetails.ProductDetailsScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mobile_development.api.TokenProvider
import com.example.mobile_development.ui.theme.MobiledevelopmentTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var tokenProvider: TokenProvider
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobiledevelopmentTheme {
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            CustomTopAppBar()
                        }
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = "producDetails",
                            modifier = Modifier.padding(it)
                        ) {
                            composable("login") {
                                LoginScreen(
                                    tokenProvider,
                                    navigateToHomeScreen = { navController.navigate("home") })
                            }
                            composable("home") {
                                HomeScreen(navigateToProductDetailsScreen = {
                                    navController.navigate(
                                        "producDetails"
                                    )
                                })
                            }
                            composable("producDetails") { ProductDetailsScreen() }

                        }
                    }
                }
            }
        }
    }
}
