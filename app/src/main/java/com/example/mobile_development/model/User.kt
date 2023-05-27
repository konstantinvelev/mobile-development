package com.example.mobile_development.model

data class Login(val identifier: String, val password: String)

data class LoginSuccess(val jwt: String, val user: User)

data class User(
    val id: Int,
    val username: String,
    val email: String,
    val provider: String,
    val confirmed: Boolean,
    val blocked: Boolean
)
