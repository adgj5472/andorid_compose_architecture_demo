package com.example.signin.data.repository

import com.example.signin.data.api.ApiService
import com.example.signin.domain.extension.repoFlow
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flowOn

class Repository(
    private val dispatcher: CoroutineDispatcher,
    private val apiService: ApiService
    ) {
    suspend fun doLogin() = repoFlow {
//        apiService.doLogin()
        apiService.getPosts()
    }.flowOn(dispatcher)
}