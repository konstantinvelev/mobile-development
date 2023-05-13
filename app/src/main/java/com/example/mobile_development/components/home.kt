import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var (username, setUsername) = remember { mutableStateOf("") }
    var (password, setPassword) = remember { mutableStateOf("") }

    Column() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Home")
            IconButton(
                modifier = modifier.size(width = 30.dp, height = 30.dp),
                onClick = { }
            ) {
                Icon(
                    Icons.Filled.AccountCircle,
                    contentDescription = "Visibility",
                    tint = Color.Gray
                )
            }
            IconButton(
                modifier = modifier.size(width = 30.dp, height = 30.dp),
                onClick = { }
            ) {
                Icon(
                    Icons.Filled.ShoppingCart,
                    contentDescription = "Visibility",
                    tint = Color.Gray
                )
            }

        }
    }
}