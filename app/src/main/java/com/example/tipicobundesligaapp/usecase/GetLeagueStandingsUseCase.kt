package com.example.tipicobundesligaapp.usecase

import com.example.tipicobundesligaapp.common.data.remote.ApiService
import com.example.tipicobundesligaapp.common.data.remote.model.getleaguestandings.LeagueStandingModel
import com.example.tipicobundesligaapp.common.data.remote.model.getleaguestandings.LeagueStandingsResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class GetLeagueStandingsUseCase @Inject constructor(private var apiService: ApiService) {
    suspend fun fetchingData(t: String, id: String, seasonId: String) = apiService.getLeagueStandings(t = t, id = id, seasonId = seasonId)
}