package com.onion.signin.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.onion.signin.domain.usecase.UseCase
import com.onion.signin.navigation.RouteNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelWebViewClient @Inject constructor(
    private val useCase: UseCase,
    private val routeNavigator: RouteNavigator
) : ViewModel(), RouteNavigator by routeNavigator {

}