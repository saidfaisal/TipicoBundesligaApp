package com.example.tipicobundesligaapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tipicobundesligaapp.common.data.remote.model.getleague.LeagueModel
import com.example.tipicobundesligaapp.common.data.remote.model.getleague.LeagueResponseModel
import com.example.tipicobundesligaapp.common.data.remote.model.getleaguestandings.LeagueStandingModel
import com.example.tipicobundesligaapp.common.data.remote.model.getleaguestandings.LeagueStandingsResponseModel
import com.example.tipicobundesligaapp.common.util.DataState
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
    private val _league = MutableLiveData<DataState<LeagueResponseModel>>()
    private val _leagueStandings get() = MutableLiveData<DataState<LeagueStandingsResponseModel>>()

    fun getLeague() {
        viewModelScope.launch(Dispatchers.IO) {
            league.postValue(getLeagueUseCase.fetchingData(GetLeagueUseCase.Params("info", "1005")))
        }
    }

    fun getLeagueStandings() {
        viewModelScope.launch(Dispatchers.IO) {
            leagueStandings.postValue(getLeagueStandingsUseCase.fetchingData(GetLeagueStandingsUseCase.Params("standings", "1005","7227")))
        }
    }
}