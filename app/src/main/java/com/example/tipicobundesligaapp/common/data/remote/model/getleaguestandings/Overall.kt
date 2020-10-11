package com.example.tipicobundesligaapp.common.data.remote.model.getleaguestandings

import com.google.gson.annotations.SerializedName

data class Overall(
    @SerializedName("games_played")
    val gamesPlayed: String,
    val won: String,
    val draw: String,
    val lost: String,
    @SerializedName("goals_diff")
    val goalsDiff: String,
    @SerializedName("goals_scored")
    val goalsScore: String,
    @SerializedName("goals_against")
    val goalsAgainst: String,
    val points: String,
    val position: String
)