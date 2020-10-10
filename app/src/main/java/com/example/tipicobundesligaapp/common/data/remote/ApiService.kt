package com.example.tipicobundesligaapp.common.data.remote

import com.example.tipicobundesligaapp.common.data.remote.model.getleaguebyid.ResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("leagues/")
    fun getLeagueById(
        @Query("user") user: String = RetrofitBuilder.username,
        @Query("token") token: String = RetrofitBuilder.token,
        @Query("t") t: String,
        @Query("id") id: String): Call<ResponseModel>
}