package com.example.tipicobundesligaapp.common.data.remote

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitBuilder {

    private const val BASE_URL = "https://api.soccersapi.com/v2.2/"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(BASE_URL)
        .build()

    const val username = "saidfaisal777"
    const val token = "f3bef441d7e81ecc686b268e1b5d7795"

    val retrofitService: ApiService = retrofit.create(ApiService::class.java)
}

//The Path
//https://ace.tokopedia.com/search/v1/product?q={{query}}
//https://ace.tokopedia.com/search/v1/shop?q={{query}}

