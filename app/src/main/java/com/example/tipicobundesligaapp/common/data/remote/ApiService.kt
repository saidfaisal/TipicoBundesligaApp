package com.example.tipicobundesligaapp.common.data.remote

import com.example.tipicobundesligaapp.common.data.remote.model.getleague.LeagueResponseModel
import com.example.tipicobundesligaapp.common.data.remote.model.getleaguestandings.LeagueStandingsResponseModel
import com.example.tipicobundesligaapp.common.util.Constant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("leagues/")
    suspend fun getLeague(
        @Query("user") user: String = Constant.USERNAME,
        @Query("token") token: String = Constant.TOKEN,
        @Query("t") t: String,
        @Query("id") id: String
    ): LeagueResponseModel

    @GET("leagues/")
    suspend fun getLeagueStandings(
        @Query("user") user: String = Constant.USERNAME,
        @Query("token") token: String = Constant.TOKEN,
        @Query("t") t: String,
        @Query("id") id: String,
        @Query("season_id") seasonId: String
    ): LeagueStandingsResponseModel
}