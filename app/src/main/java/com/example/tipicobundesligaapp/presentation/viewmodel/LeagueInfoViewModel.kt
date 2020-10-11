package com.example.tipicobundesligaapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tipicobundesligaapp.common.data.remote.model.getleague.LeagueModel
import com.example.tipicobundesligaapp.common.data.remote.model.getleaguestandings.LeagueStandingModel
import com.example.tipicobundesligaapp.usecase.GetLeagueStandingsUseCase
import com.example.tipicobundesligaapp.usecase.GetLeagueUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LeagueInfoViewModel @Inject constructor(
    private val getLeagueUseCase: GetLeagueUseCase,
    private val getLeagueStandingsUseCase: GetLeagueStandingsUseCase
): ViewModel() {

    val league get() = _league
    val leagueStandings get() = _leagueStandings
    private val _league = MutableLiveData<LeagueModel>()
    private val _leagueStandings get() = MutableLiveData<LeagueStandingModel>()

    fun getLeague() {
        viewModelScope.launch(Dispatchers.IO) {
            league.postValue(getLeagueUseCase.fetchingData("info", "1005").data)
        }
    }

    fun getLeagueStandings() {
        viewModelScope.launch(Dispatchers.IO) {
            leagueStandings.postValue(getLeagueStandingsUseCase.fetchingData("standings", "1005","7227").data)
        }
    }
}