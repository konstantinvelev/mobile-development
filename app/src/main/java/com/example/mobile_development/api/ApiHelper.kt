package com.example.etherealartefacts

import com.example.mobile_development.model.Login
import com.example.mobile_development.model.LoginSuccess

interface ApiHelper {
    suspend fun login(request: Login): LoginSuccess

//    suspend fun getProductDetails(id: Int): ProductDetailsModel
}