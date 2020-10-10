package com.example.tipicobundesligaapp.common.data.remote.model.getleaguebyid

import com.example.tipicobundesligaapp.common.data.remote.model.getleaguebyid.ContinentModel
import com.squareup.moshi.Json

data class LeagueModel (
    val id: String,
    val name: String,
    val img: String,
    @Json(name = "id_current_season")
    val idCurrentSeason: String,
    @Json(name = "id_current_round")
    val idCurrentRound: String,
    val continent: ContinentModel,
    val country: CountryModel,
    val seasons: List<SeasonModel>
)