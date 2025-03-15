package com.example.fofitest

data class LoginResponse(
    val success: Boolean,
    val message: String,
    val userId: Int? // You can add more fields if needed
)