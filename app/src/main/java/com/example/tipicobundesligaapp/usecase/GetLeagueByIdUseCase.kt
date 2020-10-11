package com.example.tipicobundesligaapp.usecase

import com.example.tipicobundesligaapp.common.data.remote.ApiService
import com.example.tipicobundesligaapp.common.data.remote.model.getleaguebyid.LeagueModel
import com.example.tipicobundesligaapp.common.data.remote.model.getleaguebyid.ResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class GetLeagueByIdUseCase @Inject constructor(private var apiService: ApiService) {

    var league: LeagueModel? = null

    suspend fun fetchingData(t: String, id: String){
        withContext(Dispatchers.IO) {
            val callback = apiService.getLeagueById(t = t, id = id)
            callback.enqueue(object : Callback<ResponseModel> {
                override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                    println(t.message)
                }

                override fun onResponse(
                    call: Call<ResponseModel>,
                    response: Response<ResponseModel>
                ) {
                    if (response.isSuccessful) {
                        league = response.body()?.data
                    }
                }
            })
        }
    }
}