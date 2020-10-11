package com.example.tipicobundesligaapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tipicobundesligaapp.common.data.remote.model.getleaguebyid.LeagueModel
import com.example.tipicobundesligaapp.usecase.GetLeagueByIdUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class LeagueInfoViewModel @Inject constructor(
    private val getLeagueByIdUseCase: GetLeagueByIdUseCase
): ViewModel() {

    val league get() = _league
    private val _league = MutableLiveData<LeagueModel>()

    fun getLeagueById() {
        viewModelScope.launch {
            getLeagueByIdUseCase.fetchingData("info", "1005")
            league.value  = getLeagueByIdUseCase.league
        }
    }
}