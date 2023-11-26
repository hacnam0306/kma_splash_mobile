package com.example.kmasplash.domain.model.post

import com.example.kmasplash.domain.model.user.User

data class Post(
    val __v: Int,
    val _id: String,
    val categories: List<Category>,
    val comments: List<Any>,
    val createdAt: String,
    val description: String,
    val fileName: String,
    val id: String,
    val likes: List<Any>,
    val title: String,
    val updatedAt: String,
    val user: User,
    val URL : String
)
