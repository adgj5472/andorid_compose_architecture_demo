package com.onion.signin.presentation.di

import com.onion.signin.data.repository.Repository
import com.onion.signin.domain.usecase.UseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PresentationModule {

    @Provides
    fun provideUseCase(repository: Repository): UseCase {
        return UseCase(repository)
    }
}