package com.example.tipicobundesligaapp.usecase

import com.example.tipicobundesligaapp.repository.LeagueRepository
import javax.inject.Inject

class GetLeagueStandingsUseCase @Inject constructor(private var leagueRepository: LeagueRepository) {

    suspend fun fetchingData(params: Params) = leagueRepository.getLeagueStandings(seasonId = params.seasonId, id = params.id, type = params.type)

    data class Params (
        val type: String,
        val id: String,
        val seasonId: String
    )

}