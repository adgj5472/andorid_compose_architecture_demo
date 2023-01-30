package com.example.signin.domain.usecase

import com.example.signin.data.dto.DtoPost
import com.example.signin.data.repository.Repository
import com.example.signin.domain.extension.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UseCase @Inject constructor(
    private val repository: Repository
) {
    suspend fun doLogin(): Flow<Result<List<DtoPost>>> {
        return repository.doLogin()
    }
}
