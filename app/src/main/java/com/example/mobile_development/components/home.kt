import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobile_development.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(R.drawable.home_page_background),
        contentDescription = "background_image",
        contentScale = ContentScale.FillBounds
    )
    Column(modifier = modifier
        .padding(horizontal = 15.dp, vertical = 20.dp)
        .fillMaxWidth()
    ) {
        Row() {
            Text(
                text = "Home",
                modifier = modifier
                    .padding(start = 150.dp, end = 70.dp, top = 10.dp, bottom = 20.dp),
                fontSize = 25.sp,
                textAlign = TextAlign.Center
            )

            IconButton(onClick = { }) {
                Icon(
                    modifier = Modifier.size(size = 32.dp),
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Account",
                    tint = Color.DarkGray
                )
            }
            IconButton(onClick = { }) {
                Icon(
                    modifier = Modifier.size(size = 33.dp),
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = "Shopping Cart",
                    tint = Color.DarkGray
                )
            }
        }

        SearchField()
    }
}
