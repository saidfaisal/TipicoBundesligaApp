package com.example.tipicobundesligaapp.common.di.module

import com.example.tipicobundesligaapp.common.data.remote.ApiService
import com.example.tipicobundesligaapp.common.di.scope.DataScope
import com.example.tipicobundesligaapp.repository.LeagueRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    @DataScope
    fun getLeagueRepository(apiService: ApiService) : LeagueRepository = LeagueRepository(apiService)
}