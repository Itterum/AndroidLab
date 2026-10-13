package com.example.jsonplaceholderapp.data.repository

class UserRepository(private val api: JsonPlaceholderService) {
    suspend fun fetchUsers(): List<User> {
        return api.getUsers()
    }
}