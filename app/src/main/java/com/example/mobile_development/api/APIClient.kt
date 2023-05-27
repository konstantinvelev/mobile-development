package com.example.mobile_development.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
class APIClient(private val interceptor: Interceptor) {
    private val DEFAULT_TIMEOUT = 1L


    val defaultService: API

    init {
        defaultService = createService()
    }

    private fun createService(): API {
        val okHttpClient: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            ).connectTimeout(DEFAULT_TIMEOUT, TimeUnit.MINUTES)
            .readTimeout(DEFAULT_TIMEOUT, TimeUnit.MINUTES)
            .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.MINUTES)
            .addInterceptor(interceptor)
            .build()

        val client = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://ethereal-artefacts.fly.dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return client.create(API::class.java)
    }
}
