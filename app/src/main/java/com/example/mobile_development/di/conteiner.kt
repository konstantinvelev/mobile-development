@file:Suppress("UnusedImport")

package com.example.etherealartefacts.di

import JWTInterceptor
import com.example.mobile_development.api.TokenProvider
import com.example.mobile_development.api.API
import com.example.mobile_development.api.APIClient
import com.google.firebase.database.core.TokenProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module()
@InstallIn(SingletonComponent::class)
object NetworkingModules {
    @Provides
    @Singleton
    fun providesTokenProvider(): TokenProvider {
        return TokenProvider()
    }

    @Provides
    @Singleton
    fun providesJWTInterceptor(tokenProvider: TokenProvider): JWTInterceptor {
        return JWTInterceptor(tokenProvider)
    }

    @Provides
    @Singleton
    fun providesAPI(providesJWTInterceptor: JWTInterceptor): API {
        return APIClient(providesJWTInterceptor).defaultService
    }
}