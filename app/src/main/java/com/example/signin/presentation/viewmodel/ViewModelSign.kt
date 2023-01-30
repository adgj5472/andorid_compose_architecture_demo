package com.example.signin.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.signin.domain.usecase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelSign @Inject constructor(
    private val useCase: UseCase
): ViewModel() {

}