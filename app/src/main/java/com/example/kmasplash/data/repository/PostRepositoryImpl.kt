package com.example.kmasplash.data.repository

import android.util.Log
import com.example.kmasplash.core.Constants.LIMIT
import com.example.kmasplash.core.common.Resource
import com.example.kmasplash.data.api.KmaSplashApi
import com.example.kmasplash.domain.model.PagedResponse
import com.example.kmasplash.domain.model.post.Category
import com.example.kmasplash.domain.model.post.Post
import com.example.kmasplash.domain.repository.PostRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch

@ViewModelScoped
class PostRepositoryImpl  @Inject constructor(
    private val api: KmaSplashApi
) : PostRepository {
    override fun getPosts(page:Int) :Flow<Resource<PagedResponse<Post>>> = flow {
        emit(Resource.Loading())
        val result = api.getPosts(page)
        emit(Resource.Success(result))
    }.flowOn(Dispatchers.IO).catch {
        Log.e("Error Herer",it.message.toString())
        emit(Resource.Error(it.message.toString()))
    }

    override fun getPostsCategory(page:Int,category: String): Flow<Resource<PagedResponse<Post>>> = flow {
        emit(Resource.Loading())
        val result = api.getPostsCategory(page, LIMIT,category)
        emit(Resource.Success(result))
    }.flowOn(Dispatchers.IO).catch {
        emit(Resource.Error(it.message.toString()))
    }


    override fun getPostById(postId: String): Flow<Resource<Post>> = flow {
        emit(Resource.Loading())
        val result = api.getPostById(postId)
        emit(Resource.Success(result))
    }.flowOn(Dispatchers.IO).catch {
        emit(Resource.Error(it.message.toString()))
    }


    override fun getCategories(): Flow<Resource<List<Category>>> = flow {
        emit(Resource.Loading())
        val result = api.getCategories()
        emit(Resource.Success(result))
    }.flowOn(Dispatchers.IO).catch {
        emit(Resource.Error(it.message.toString()))
    }

    override fun getUserPosts(userId:String,page:Int) :Flow<Resource<PagedResponse<Post>>> = flow {
        emit(Resource.Loading())
        val result = api.getUserPosts(page,LIMIT,userId)
        emit(Resource.Success(result))
    }.flowOn(Dispatchers.IO).catch {
        emit(Resource.Error(it.message.toString()))
    }
}
