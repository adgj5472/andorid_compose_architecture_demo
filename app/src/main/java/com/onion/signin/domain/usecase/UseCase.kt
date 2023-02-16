package com.onion.signin.domain.usecase

import com.onion.signin.data.dto.DtoPost
import com.onion.signin.data.repository.Repository
import com.onion.signin.domain.extension.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UseCase @Inject constructor(
    private val repository: Repository
) {
    suspend fun doLogin(): Flow<Result<List<DtoPost>>> {
        return repository.doLogin()
    }
}
