package com.example.fofitest

data class SignupRequest(
    val username: String,
    val email: String,
    val password: String,
    val confirmPassword: String
)