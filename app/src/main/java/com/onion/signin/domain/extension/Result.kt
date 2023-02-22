package com.onion.signin.domain.extension

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

sealed class Result<out T> {
    data class Loading(val isLoading: Boolean) : Result<Nothing>()
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val error: String) : Result<Nothing>()
}

suspend inline fun <T> repoFlow(
    crossinline block: suspend () -> T,
): Flow<Result<T>> = flow {
    try {
        emit(Result.Loading(true))
        val repoResult = block()
        emit(Result.Success(repoResult))
    } catch (e: Exception) {
        emit(Result.Error(e.message ?: "Unknown error"))
    }
}