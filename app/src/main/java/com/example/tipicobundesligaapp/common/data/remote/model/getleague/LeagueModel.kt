package com.example.tipicobundesligaapp.common.data.remote.model.getleague

import com.google.gson.annotations.SerializedName

data class LeagueModel (
    val id: String,
    val name: String,
    val img: String,
    @SerializedName("id_current_season")
    val idCurrentSeason: String,
    @SerializedName("id_current_round")
    val idCurrentRound: String,
    val continent: ContinentModel,
    val country: CountryModel,
    val seasons: List<SeasonModel>
)