package com.example.tipicobundesligaapp.common.data.remote

import com.example.tipicobundesligaapp.common.data.remote.model.getleaguebyid.ResponseModel
import com.example.tipicobundesligaapp.common.util.Constant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("leagues/")
    fun getLeagueById(
        @Query("user") user: String = Constant.USERNAME,
        @Query("token") token: String = Constant.TOKEN,
        @Query("t") t: String,
        @Query("id") id: String): Call<ResponseModel>
}