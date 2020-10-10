package com.example.tipicobundesligaapp.common.data.remote.model.getleaguebyid

import com.squareup.moshi.Json

class SeasonModel (
    val id: String,
    val name: String,
    @Json(name = "is_current")
    val isCurrent: String
)