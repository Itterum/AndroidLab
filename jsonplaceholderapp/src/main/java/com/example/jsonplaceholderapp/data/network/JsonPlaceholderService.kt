package com.example.jsonplaceholderapp.data.network

interface JsonPlaceholderService {
    @GET("users")
    suspend fun getUsers(): List<User>

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }
}