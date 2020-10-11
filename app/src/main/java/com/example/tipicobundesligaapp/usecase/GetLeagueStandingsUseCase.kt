package com.example.tipicobundesligaapp.usecase

import com.example.tipicobundesligaapp.common.data.remote.ApiService
import javax.inject.Inject

class GetLeagueStandingsUseCase @Inject constructor(private var apiService: ApiService) {
    suspend fun fetchingData(t: String, id: String, seasonId: String) = apiService.getLeagueStandings(t = t, id = id, seasonId = seasonId)
}