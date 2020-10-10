package com.example.tipicobundesligaapp.common.di.component

import com.example.tipicobundesligaapp.common.di.module.ViewModelFactoryModule
import com.example.tipicobundesligaapp.common.di.module.ViewModelModule
import com.example.tipicobundesligaapp.common.di.scope.DataScope
import com.example.tipicobundesligaapp.presentation.activity.LeagueInfoActivity
import dagger.Component
import javax.inject.Singleton

@DataScope
@Singleton
@Component(modules = [ViewModelModule::class, ViewModelFactoryModule::class])
interface AppComponent {
    fun inject(leagueInfoActivity: LeagueInfoActivity)
}