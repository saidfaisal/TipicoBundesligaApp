package com.example.tipicobundesligaapp.common.data.remote.model.getleague

import com.google.gson.annotations.SerializedName

data class SeasonModel (
    val id: String,
    val name: String,
    @SerializedName("is_current")
    val isCurrent: String
)