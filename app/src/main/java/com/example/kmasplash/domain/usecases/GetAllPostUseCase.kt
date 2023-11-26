package com.example.kmasplash.domain.usecases

import com.example.kmasplash.domain.repository.PostRepository
import javax.inject.Inject

class GetAllPostUseCase @Inject constructor(
    private  val repository: PostRepository
){
    operator fun invoke(page:Int) = repository.getPosts(page)
}
