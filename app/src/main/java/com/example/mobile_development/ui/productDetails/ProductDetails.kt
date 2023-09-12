package com.example.mobile_development.ui.productDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.etherealartefacts.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailsScreen(modifier: Modifier = Modifier) {
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
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            modifier = Modifier.fillMaxWidth()
                .size(width =  350.dp, height = 350.dp   ),
            painter = painterResource(R.drawable.product_image),
            contentDescription = "product_image",
            contentScale = ContentScale.FillWidth
        )

        Row(
            modifier = Modifier.padding(horizontal = 0.dp, vertical = 15.dp )
        ) {
            Column(modifier = Modifier.padding(start = 0.dp, top = 0.dp, end = 30.dp, bottom = 0.dp)) {
                Text(
                    text = "Anton Petrov na lager v Tailnd",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "Category: Muay Thay")
            }


            Text(text = "StarStarStar")
        }

        Text(text = "Indulge in a heavenly tea experience with our Stargazer’s Tea Set, featuring a constellation-themed teapot and matching teacups. Crafted from fine porcelain, this elegant set will transport you to the cosmos with every sip.")


        Text(text = "90$")
    }
}
