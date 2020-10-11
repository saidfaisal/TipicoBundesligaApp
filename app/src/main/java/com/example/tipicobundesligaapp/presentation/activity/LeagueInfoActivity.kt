package com.example.tipicobundesligaapp.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.tipicobundesligaapp.R
import com.example.tipicobundesligaapp.common.di.component.DaggerAppComponent
import com.example.tipicobundesligaapp.presentation.viewmodel.LeagueInfoViewModel
import kotlinx.android.synthetic.main.activity_league_info.*
import javax.inject.Inject

class LeagueInfoActivity : AppCompatActivity() {
    
    @Inject
    lateinit var leagueInfoViewModel: LeagueInfoViewModel
    private var observeForFirstTime = true
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league_info)
        initDagger()

        cardView.setOnClickListener {
            leagueInfoViewModel.getLeagueById()
        }
        fetchingData()
        oberverLiveData()
    }

    private fun initDagger() {
        DaggerAppComponent.builder().build().inject(this)
    }

    private fun fetchingData() {
        leagueInfoViewModel.getLeagueById()
    }

    private fun oberverLiveData() {
        leagueInfoViewModel.league.observe(this, Observer { leagueModel ->
            if (observeForFirstTime) {
                fetchingData()
                observeForFirstTime = false
            }
            leagueModel?.let {
                tvNameLeague.text = it.name
                tvSession.text = it.seasons.first().name
                tvContinentCountry.text = "${it.continent.name} - ${it.country.name}"
                Glide.with(this).load(it.img).centerCrop().into(ivLeague)
            }
        })
    }
}