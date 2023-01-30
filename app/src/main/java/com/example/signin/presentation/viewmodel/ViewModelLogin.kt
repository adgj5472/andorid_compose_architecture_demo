package com.example.signin.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.signin.data.dto.DtoPost
import com.example.signin.domain.usecase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject
import com.example.signin.domain.extension.Result

@HiltViewModel
class ViewModelLogin @Inject constructor(
    private val useCase: UseCase
): ViewModel() {
    private val _state: MutableStateFlow<List<DtoPost>> = MutableStateFlow(emptyList())
    val state: StateFlow<List<DtoPost>> = _state

    private val _loadingState = MutableStateFlow(false)
    val loadingState: StateFlow<Boolean> = _loadingState

    private val _errorState = MutableStateFlow("")
    val errorState: StateFlow<String> = _errorState
    fun doLogin() {
        CoroutineScope(Dispatchers.IO).launch {

        }
        viewModelScope.launch {
            _loadingState.value = true
            useCase.doLogin().collect {
                Timber.d("@@@@@@@ ${it.toString()}")
                when(it) {
                    is Result.Loading -> {
                        _loadingState.value = true
                    }
                    is Result.Success -> {
                        _loadingState.value = false
                        _state.value = it.data
                    }
                    is Result.Error -> {
                        _loadingState.value = false
                        _errorState.value = it.error
                    }
                }
            }
        }
    }
}