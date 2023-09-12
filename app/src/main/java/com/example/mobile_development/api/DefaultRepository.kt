package com.example.etherealartefacts
import com.example.mobile_development.api.API
import com.example.mobile_development.model.Login
import com.example.mobile_development.model.LoginSuccess

class DefaultRepository(private val apiService: API): ApiHelper {
    override suspend fun login(request: Login) : LoginSuccess {
        return apiService.login(request)
    }

//    override suspend fun getProductDetails(id: Int): ProductDetailsModel {
//        return apiService.getProductDetails(id)
//    }
}