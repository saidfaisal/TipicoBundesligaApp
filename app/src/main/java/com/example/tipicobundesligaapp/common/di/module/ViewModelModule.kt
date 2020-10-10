package com.example.tipicobundesligaapp.common.di.module

import androidx.lifecycle.ViewModel
import com.example.tipicobundesligaapp.common.di.key.ViewModelKey
import com.example.tipicobundesligaapp.common.di.scope.DataScope
import com.example.tipicobundesligaapp.presentation.viewmodel.LeagueInfoViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @DataScope
    @Binds
    @IntoMap
    @ViewModelKey(LeagueInfoViewModel::class)
    abstract fun bindShopViewModel(leagueInfoViewModel: LeagueInfoViewModel?): ViewModel?

}