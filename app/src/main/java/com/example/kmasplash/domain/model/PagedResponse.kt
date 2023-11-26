package com.example.kmasplash.domain.model

data class PagedResponse<T>(
    val posts: List<T>,
    val page: Int,
    val totalPage: Int
)
