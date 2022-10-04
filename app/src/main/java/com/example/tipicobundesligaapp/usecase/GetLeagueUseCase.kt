package com.example.tipicobundesligaapp.usecase

import com.example.tipicobundesligaapp.repository.LeagueRepository
import javax.inject.Inject


class GetLeagueUseCase @Inject constructor(private var leagueRepository: LeagueRepository) {
    suspend fun fetchingData(params: Params) = leagueRepository.getLeague(type = params.type, id = params.id)

    data class Params (
        val type: String,
        val id: String
    )
}