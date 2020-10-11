package com.example.tipicobundesligaapp.common.data.remote.model.getleaguestandings
import com.google.gson.annotations.SerializedName

data class Standing (
    @SerializedName("team_id")
    val teamId: String,
    @SerializedName("team_name")
    val teamName: String,
    val overall: Overall
)