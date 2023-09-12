import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.etherealartefacts.R
import com.example.mobile_development.api.APIClient
import com.example.mobile_development.api.JWTInterceptor
import com.example.mobile_development.api.TokenProvider
import com.example.mobile_development.ui.productDetails.ProductDetailsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navigateToProductDetailsScreen: () -> Unit = {}, modifier: Modifier = Modifier) {
    var product: ProductDetailsViewModel? by remember { mutableStateOf(null) }
    var coroutineScope = rememberCoroutineScope()
    val tokenProvider = TokenProvider()
    val interceptor = JWTInterceptor(tokenProvider)
    val apiClient = APIClient(interceptor)

    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(R.drawable.home_page_background),
        contentDescription = "background_image",
        contentScale = ContentScale.FillBounds
    )
    Column(
        modifier = Modifier
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
       // Row() {
//            Text(
//                text = "Home",
//                modifier = Modifier
//                    .padding(start = 150.dp, end = 70.dp, top = 10.dp, bottom = 20.dp),
//                fontSize = 25.sp,
//                textAlign = TextAlign.Center
//            )
//
//            IconButton(onClick = { }) {
//                Icon(
//                    modifier = Modifier.size(size = 32.dp),
//                    imageVector = Icons.Default.AccountCircle,
//                    contentDescription = "Account",
//                    tint = Color.DarkGray
//                )
//            }
//            IconButton(onClick = { }) {
//                Icon(
//                    modifier = Modifier.size(size = 33.dp),
//                    imageVector = Icons.Filled.ShoppingCart,
//                    contentDescription = "Shopping Cart",
//                    tint = Color.DarkGray
//                )
//            }
//        }

        SearchField()

        Button(onClick = {
            coroutineScope.launch (Dispatchers.IO){
                product = apiClient.defaultService.getProduct()
            }
        }) {

        }
        product?.let{
            Text(text = it.title)
        }

//        for (i in 1..3) {
//            Button(
//                modifier = Modifier.fillMaxWidth(),
//                onClick = navigateToProductDetailsScreen ) {
//                Row() {
//                    Image(
//                        painter = painterResource(R.drawable.product_image),
//                        contentDescription = "product_image",
//                        contentScale = ContentScale.Inside
//                    )
//
//                    Column() {
//                        Text(text = "Category")
//                        Text(text = "Name")
//                        Text(text = "Shord Description")
//                        Text(text = "Rate")
//                        Text(text = "Price -> 5000$")
//                    }
//                }
//            }
//        }
    }
}


