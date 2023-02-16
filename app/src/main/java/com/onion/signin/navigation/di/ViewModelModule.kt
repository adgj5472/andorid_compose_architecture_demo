package com.onion.signin.navigation.di

import com.onion.signin.navigation.CommonRouteNavigator
import com.onion.signin.navigation.RouteNavigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
class ViewModelModule {

    @Provides
    @ViewModelScoped
    fun bindRouteNavigator(): RouteNavigator = CommonRouteNavigator()
}