@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.mobile_development

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mobile_development.ui.theme.MobiledevelopmentTheme
import java.util.regex.Pattern


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobiledevelopmentTheme {
                val navController =  rememberNavController()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold {
                        NavHost(navController = navController,
                            startDestination = "login",
                        modifier = Modifier.padding(it)
                        ) {
                            composable("login") { LoginScreen(navigateToHomeScreen = { navController.navigate("home") }) }
                            composable("home") { HomeScreen() }
                        }
                    }



                }
            }
        }
    }
}

@Composable
fun LoginScreen(navigateToHomeScreen: () -> Unit={},modifier: Modifier = Modifier) {
    var (email, setEmail) = remember { mutableStateOf("") }
    var (password, setPassword) = remember { mutableStateOf("") }
    var (showPass, setShowPass) = remember { mutableStateOf(false) }
    var (isError, setIsError) = remember { mutableStateOf(false) }

    fun ValidateEmail(): Boolean {
        if(email != "") {
            var isValid = email.length > 3 && EMAIL_ADDRESS_PATTERN.matcher(email).matches()
            setIsError(!isValid)
        return isValid
        }
        return  true
    }


    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(R.drawable.etherealartefacts_login_background),
        contentDescription = "background_image",
        contentScale = ContentScale.FillBounds
    )
    Column(modifier = modifier.fillMaxSize()) {

        Row(
            modifier = Modifier
                .size(width = 800.dp, height = 230.dp)
                .padding(50.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(width = 500.dp, height = 800.dp)
                    .padding(0.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.ethereal_artefacts_logo),
                contentDescription = "background_image",
                contentScale = ContentScale.Inside
            )
        }

        Row(
            modifier = Modifier
                .size(width = 400.dp, height = 70.dp)
                .padding(10.dp)
        ) {
            Text(
                text = "Log in",
                modifier = modifier,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
            )
        }

        Row(
            modifier = Modifier
                .size(width = 400.dp, 100.dp)
                .padding(10.dp)
        ) {
            OutlinedTextField(
                modifier = modifier
                    .size(width = 400.dp, height = 50.dp)
                    .fillMaxSize(),
                value = email,
                onValueChange = { newValue -> setEmail(newValue) },
                placeholder = { Text("Email") },
                isError = !ValidateEmail(),
                supportingText = {
                    if (!ValidateEmail()) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Invalid email",
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                },
            )
        }

        Row(
            modifier = Modifier
                .padding(10.dp)
        ) {
            OutlinedTextField(
                modifier = modifier
                    .size(width = 400.dp, height = 50.dp)
                    .fillMaxSize(),
                value = password,
                onValueChange = { newValue -> setPassword(newValue) },
                placeholder = { Text("Password") },
                visualTransformation = if (showPass) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val (icon, iconColor) = if (showPass) {
                        Pair(
                            Icons.Filled.Visibility,
                            Color(Color.Gray.value)
                        )

                    } else {
                        Pair(Icons.Filled.VisibilityOff, Color(Color.Gray.value))
                    }

                    IconButton(onClick = { setShowPass(!showPass)  }) {
                        Icon(
                            icon,
                            contentDescription = "Visibility",
                            tint = iconColor
                        )
                    }
                }
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(vertical = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                modifier=modifier.size(width = 300.dp, height = 35.dp),
                onClick = navigateToHomeScreen) {

                Text(text = "Login")
            }
        }

    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var (username, setUsername) = remember { mutableStateOf("") }
    var (password, setPassword) = remember { mutableStateOf("") }


        Row(
            modifier = Modifier
                .size(width = 800.dp, height = 230.dp)
                .padding(50.dp)
        ) {
           Text(text = "Home")
        }
}



val EMAIL_ADDRESS_PATTERN: Pattern = Pattern.compile(
    "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
            "\\@" +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
            "(" +
            "\\." +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
            ")+"
)



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MobiledevelopmentTheme {
        LoginScreen()
    }
}
