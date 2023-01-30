package com.example.signin.domain.extension

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber

sealed class Result<out T> {
    object Loading: Result<Nothing>()
    data class Success<out T>(val data: T): Result<T>()
    data class Error(val error: String): Result<Nothing>()
}

inline fun <T> repoFlow(
    crossinline block: suspend () -> T,
): Flow<Result<T>> = flow {
    try {
        val repoResult = block()
        Log.e("@@@@@@@@@@@@@@@", repoResult.toString())
        Timber.d("@@@@@1 ${repoResult.toString()}")
        val a = Result.Success(repoResult)
        Log.e("@@@@@@@@@@@@@@@", a.toString())
        Timber.d("@@@@@2 ${a.toString()}")
        emit(a)
    } catch (e: Exception) {
        Timber.d("@@@@@3 ${e}, ${e.message}")
        emit(Result.Error(e.message ?: "Unknown error"))
    }
}