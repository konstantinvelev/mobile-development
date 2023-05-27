package com.example.mobile_development.api

import com.example.etherealartefacts.LoginViewModel
import com.example.mobile_development.model.Login
import com.example.mobile_development.model.LoginSuccess
import com.example.mobile_development.ui.productDetails.ProductDetailsViewModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface API {
    @GET(value = "products/:productId?populate=*")
    suspend fun getProduct(): ProductDetailsViewModel?

    @POST(value = "auth/local")
    suspend fun login(@Body user: Login): LoginSuccess
}