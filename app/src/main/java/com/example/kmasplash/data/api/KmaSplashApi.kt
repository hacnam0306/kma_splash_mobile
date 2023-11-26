package com.example.kmasplash.data.api

import com.example.kmasplash.core.Constants.LIMIT
import com.example.kmasplash.domain.model.PagedResponse
import com.example.kmasplash.domain.model.post.Category
import com.example.kmasplash.domain.model.post.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface KmaSplashApi {
    @GET("/post")
    suspend fun getPosts(
        @Query("page") page: Int,
        @Query("limit") perPage: Int = LIMIT
        ,
    ):PagedResponse<Post>

    @GET("/post")
    suspend fun getPostsCategory(
        @Query("page") page: Int,
        @Query("limit") perPage: Int = LIMIT,
        @Query("category") category:String
        ,
    ):PagedResponse<Post>

    @GET("posts/{postId}")
    suspend fun getPostById(
        @Path("postId") postId: String,
    ): Post

    @GET("/category")
    suspend fun getCategories(): List<Category>

    @GET("/post/user/{userId}")
    suspend fun getUserPosts(
        @Query("page") page: Int,
        @Query("limit") perPage: Int = LIMIT,
        @Path("userId") userId: String,
    ):PagedResponse<Post>
}
