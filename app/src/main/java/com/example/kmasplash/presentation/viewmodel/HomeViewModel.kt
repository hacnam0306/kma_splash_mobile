package com.example.kmasplash.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmasplash.core.common.Resource
import com.example.kmasplash.domain.usecases.GetAllPostUseCase
import com.example.kmasplash.presentation.state.PostListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import kotlin.math.E

@HiltViewModel
class HomeViewModel @Inject constructor(
    private  val useCase: GetAllPostUseCase
):
    ViewModel() {

    private val _postsState = MutableStateFlow(PostListState())

    val postState: StateFlow<PostListState> get() = _postsState


    init {
        getPosts(page=1)
    }

    private fun getPosts(page:Int){
        useCase(page).onEach {
            when (it){
                is Resource.Loading -> {
                    _postsState.value = PostListState().copy(true)
                }
                is Resource.Success -> {
                    _postsState.value = PostListState().copy(posts = it.data?.posts)
                }
                is Resource.Error -> {
                    _postsState.value = PostListState().copy(error = it.msg)
                }
            }
        }.launchIn(viewModelScope)
    }
}
