package com.example.kmasplash.domain.repository

import com.example.kmasplash.core.common.Resource
import com.example.kmasplash.domain.model.PagedResponse
import com.example.kmasplash.domain.model.post.Category
import com.example.kmasplash.domain.model.post.Post
import kotlinx.coroutines.flow.Flow
interface PostRepository {
    fun getPosts(page:Int): Flow<Resource<PagedResponse<Post>>>
    fun getPostsCategory(page: Int,category:String): Flow<Resource<PagedResponse<Post>>>

    fun getPostById(postId: String): Flow<Resource<Post>>

    fun getCategories(): Flow<Resource<List<Category>>>

    fun getUserPosts(userId: String,page:Int): Flow<Resource<PagedResponse<Post>>>


}
