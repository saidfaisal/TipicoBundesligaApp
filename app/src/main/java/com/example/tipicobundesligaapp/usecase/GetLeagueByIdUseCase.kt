package com.example.tipicobundesligaapp.usecase

import com.example.tipicobundesligaapp.common.data.remote.RetrofitBuilder
import com.example.tipicobundesligaapp.common.data.remote.model.getleaguebyid.LeagueModel
import com.example.tipicobundesligaapp.common.data.remote.model.getleaguebyid.ResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class GetLeagueByIdUseCase @Inject constructor() {

    private var league: LeagueModel? = null

    suspend fun fetchingData(): LeagueModel? {
        withContext(Dispatchers.IO) {
            RetrofitBuilder.retrofitService.getLeagueById(t = "info", id = "1005").enqueue(object : Callback<ResponseModel> {
                override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                    println(t.message)
                }

                override fun onResponse(
                    call: Call<ResponseModel>,
                    response: Response<ResponseModel>
                ) {
                    league = response.body()?.data
                }
            })
        }
        return league
    }
}