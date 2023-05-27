import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.mobile_development.ui.theme.MainBorder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchField(modifier: Modifier = Modifier) {
    var (searchParameter, setSearchParameter) = remember { mutableStateOf("") }
    var (showClearIcon, setShowClearIcon) = remember { mutableStateOf(false) }
    TextField(
        modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.Transparent, shape = RoundedCornerShape(8.dp)),
        shape = RoundedCornerShape(60.dp),
        value = searchParameter,
        onValueChange = { newValue: String -> setSearchParameter(newValue) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                tint = MainBorder,
                contentDescription = "Search icon"
            )
        },
        trailingIcon = {
            if (showClearIcon) {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Filled.Clear,
                        tint = MainBorder,
                        contentDescription = "Clear icon"
                    )
                }
            }
        },
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        placeholder = { Text(text = "Search") },
        textStyle = MaterialTheme.typography.labelMedium,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),

    )
}
