package com.example.tipicobundesligaapp.repository

import com.example.tipicobundesligaapp.common.data.remote.ApiService
import com.example.tipicobundesligaapp.common.data.remote.model.getleague.LeagueResponseModel
import com.example.tipicobundesligaapp.common.data.remote.model.getleaguestandings.LeagueStandingsResponseModel
import com.example.tipicobundesligaapp.common.data.remote.model.getleaguestandings.Standing
import com.example.tipicobundesligaapp.common.util.Constant
import com.example.tipicobundesligaapp.common.util.DataState
import javax.inject.Inject

class LeagueRepository
@Inject
constructor (
    private val leagueApiService: ApiService
) {

    suspend fun getLeagueStandings(type: String, id: String, seasonId: String) : DataState<LeagueStandingsResponseModel> {
        return try {
            val response = leagueApiService.getLeagueStandings(t = type, id = id, seasonId = seasonId)
            DataState.Success(response)
        } catch (e: Exception) {
            DataState.Error(Exception(Constant.UNKNOWN_ERROR_MESSAGE))
        }
    }

    suspend fun getLeague(type: String, id: String) : DataState<LeagueResponseModel> {
        return try {
            val response = leagueApiService.getLeague(t = type, id = id)
            DataState.Success(response)
        } catch (e: Exception) {
            DataState.Error(Exception(Constant.UNKNOWN_ERROR_MESSAGE))
        }
    }

}