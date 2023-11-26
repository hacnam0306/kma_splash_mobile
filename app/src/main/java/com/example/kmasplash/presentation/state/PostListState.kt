package com.example.kmasplash.presentation.state

import com.example.kmasplash.domain.model.PagedResponse
import com.example.kmasplash.domain.model.post.Post

data class PostListState(
    val isLoading: Boolean = false,
    val posts: List<Post>? = emptyList(),
    val error: String? = "",
    val total: Int = 0
)
