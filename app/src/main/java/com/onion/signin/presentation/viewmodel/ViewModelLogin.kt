package com.onion.signin.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onion.signin.data.dto.DtoPost
import com.onion.signin.domain.extension.Result
import com.onion.signin.domain.usecase.UseCase
import com.onion.signin.navigation.RouteNavigator
import com.onion.signin.ui.compose.SignRoute
import com.onion.signin.ui.compose.WebViewClientRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ComposeLoginUIState(
    var loadingState: Boolean = false,
)

@HiltViewModel
class ViewModelLogin @Inject constructor(
    private val useCase: UseCase,
    private val routeNavigator: RouteNavigator
) : ViewModel(), RouteNavigator by routeNavigator {
    private val _state: MutableStateFlow<List<DtoPost>> = MutableStateFlow(emptyList())
    val state: StateFlow<List<DtoPost>> = _state

    private val _composeLoginUIState = MutableStateFlow(ComposeLoginUIState())
    val composeLoginUIState: StateFlow<ComposeLoginUIState> = _composeLoginUIState

    private val _errorState = MutableStateFlow("")
    val errorState: StateFlow<String> = _errorState

    fun gotoWebViewClient() {
        routeNavigator.navigateToRoute(WebViewClientRoute.route)
    }

    fun doLogin() {
        viewModelScope.launch(Dispatchers.Main) {
            useCase.doLogin().collect {
                when (it) {
                    is Result.Loading -> {
                        _composeLoginUIState.update { state ->
                            state.copy(loadingState = true)
                        }
                    }
                    is Result.Success -> {
                        _composeLoginUIState.update { state ->
                            state.copy(loadingState = false)
                        }
                        _state.value = it.data
                        routeNavigator.navigateToRoute(SignRoute.route)
                    }
                    is Result.Error -> {
                        _composeLoginUIState.update { state ->
                            state.copy(loadingState = false)
                        }
                        _errorState.value = it.error
                    }
                }
            }
        }
    }
}