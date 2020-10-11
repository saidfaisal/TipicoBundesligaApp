package com.example.tipicobundesligaapp.usecase

import com.example.tipicobundesligaapp.common.data.remote.ApiService
import javax.inject.Inject


class GetLeagueUseCase @Inject constructor(private var apiService: ApiService) {
    suspend fun fetchingData(t: String, id: String) = apiService.getLeague(t = t, id = id)
}