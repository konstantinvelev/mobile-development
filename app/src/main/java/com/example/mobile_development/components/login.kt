import android.text.TextUtils
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobile_development.R
import com.example.mobile_development.ui.theme.BorderOnFocus
import com.example.mobile_development.ui.theme.MainBorder
import com.example.mobile_development.ui.theme.MainDark

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navigateToHomeScreen: () -> Unit = {}, modifier: Modifier = Modifier) {
    var (email, setEmail) = remember { mutableStateOf("") }
    var (password, setPassword) = remember { mutableStateOf("") }
    var (showPass, setShowPass) = remember { mutableStateOf(false) }
    var (isError, setIsError) = remember { mutableStateOf(false) }

    fun validateEmail(): Boolean {
        if (!TextUtils.isEmpty(email)) {
            var isValid =
                email.length >= 3 && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
            setIsError(isValid)
            return isValid
        }
        return true
    }

    fun validatePassword(): Boolean {
        if (!TextUtils.isEmpty(password)) {
            var isValid = password.length >= 3 && password.length <= 30
            setIsError(isValid)
            return isValid
        }
        return true
    }

    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(R.drawable.etherealartefacts_login_background),
        contentDescription = "background_image",
        contentScale = ContentScale.FillBounds
    )
    Column(
        modifier = modifier
            .padding(horizontal = 15.dp, vertical = 35.dp)
            .fillMaxSize()
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 40.dp),
            imageVector = ImageVector.vectorResource(id = R.drawable.ethereal_artefacts_logo),
            contentDescription = "logo-image",
            contentScale = ContentScale.Inside
        )

        Text(
            text = "Log in",
            modifier = modifier,
            fontSize = 30.sp,
            color = MainDark,
            fontWeight = FontWeight.Bold,
        )

        OutlinedTextField(
            modifier = modifier
                .padding(start = 0.dp, end = 0.dp, top = 20.dp, bottom = 15.dp)
                .fillMaxWidth(),
            value = email,
            onValueChange = { newValue -> setEmail(newValue) },
            label = { Text(text = "Email") },
            placeholder = { Text(text = "Type your email") },
            isError = !validateEmail(),
            supportingText = {
                if (!validateEmail()) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = "Invalid email",
                        color = MaterialTheme.colorScheme.error
                    )
                }
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedLabelColor = MainBorder,
                unfocusedBorderColor = MainBorder,
                focusedBorderColor = BorderOnFocus,
                focusedLabelColor = BorderOnFocus,
                errorLabelColor = Color.Red
            ),
        )

        OutlinedTextField(
            modifier = modifier
                .padding(start = 0.dp, end = 0.dp, top = 5.dp, bottom = 40.dp)
                .fillMaxWidth(),
            value = password,
            onValueChange = { newValue -> setPassword(newValue) },
            label = { Text(text = "Password")},
            placeholder = { Text(text = "Type your password") },
            visualTransformation = if (showPass) VisualTransformation.None else PasswordVisualTransformation(),
            isError = !validatePassword(),
            supportingText = {
                if (!validatePassword()) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = "The password should be between 3 and 30 letters",
                        color = MaterialTheme.colorScheme.error
                    )
                }
            },
            trailingIcon = {
                val (icon, iconColor) = if (showPass) {
                    Pair(Icons.Filled.Visibility, MainBorder)
                } else {
                    Pair(Icons.Filled.VisibilityOff, MainBorder)
                }

                IconButton(onClick = { setShowPass(!showPass) }) {
                    Icon(
                        icon,
                        contentDescription = "Visibility",
                        tint = iconColor
                    )
                }
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedLabelColor = MainBorder,
                unfocusedBorderColor = MainBorder,
                focusedBorderColor = BorderOnFocus,
                focusedLabelColor = BorderOnFocus,
                errorLabelColor = Color.Red
            ),
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                modifier = modifier
                    .size(width = 400.dp, height = 35.dp)
                    .padding(horizontal = 20.dp),
                enabled = isError,
                onClick = navigateToHomeScreen,
                colors = ButtonDefaults.buttonColors(MainDark)
            ) {
                Text(text = "Login")
            }
        }
    }
}
