@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.mobile_development.main

import HomeScreen
import LoginScreen
import com.example.mobile_development.ui.productDetails.ProductDetailsScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mobile_development.ui.theme.MobiledevelopmentTheme


class MainActivity : ComponentActivity() {
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
                    Scaffold {
                        NavHost(
                            navController = navController,
                            startDestination = "login",
                            modifier = Modifier.padding(it)
                        ) {
                            composable("login") { LoginScreen(navigateToHomeScreen ={ navController.navigate("home")}) }
                            composable("home") { HomeScreen(navigateToProductDetailsScreen ={ navController.navigate("producDetails")}) }
                            composable("producDetails") { ProductDetailsScreen() }

                        }
                    }
                }
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MobiledevelopmentTheme {
        LoginScreen()
    }
}
