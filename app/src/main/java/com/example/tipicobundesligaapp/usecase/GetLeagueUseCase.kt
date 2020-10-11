package com.example.tipicobundesligaapp.usecase

import com.example.tipicobundesligaapp.common.data.remote.ApiService
import com.example.tipicobundesligaapp.common.data.remote.model.getleague.LeagueModel
import com.example.tipicobundesligaapp.common.data.remote.model.getleague.LeagueResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class GetLeagueUseCase @Inject constructor(private var apiService: ApiService) {
    suspend fun fetchingData(t: String, id: String) = apiService.getLeague(t = t, id = id)
}