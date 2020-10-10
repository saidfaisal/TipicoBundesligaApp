package com.example.tipicobundesligaapp.common.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.tipicobundesligaapp.presentation.viewmodel.ViewModelFactory

import com.example.tipicobundesligaapp.common.di.scope.DataScope
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @DataScope
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}