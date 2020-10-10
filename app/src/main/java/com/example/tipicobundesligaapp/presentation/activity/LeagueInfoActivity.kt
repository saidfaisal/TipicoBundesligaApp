package com.example.tipicobundesligaapp.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.tipicobundesligaapp.R
import com.example.tipicobundesligaapp.common.di.component.DaggerAppComponent
import com.example.tipicobundesligaapp.presentation.viewmodel.LeagueInfoViewModel
import kotlinx.android.synthetic.main.activity_league_info.*
import javax.inject.Inject

class LeagueInfoActivity : AppCompatActivity() {
    
    @Inject
    lateinit var leagueInfoViewModel: LeagueInfoViewModel
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league_info)
        initDagger()

        buttonCommon.setOnClickListener {
            leagueInfoViewModel.getLeagueById()
        }

        oberverLiveData()
    }

    private fun initDagger() {
        DaggerAppComponent.builder().build().inject(this)
    }

    private fun oberverLiveData() {
        leagueInfoViewModel.league.observe(this, Observer {
            it?.let {
                println("Testing : ${it.name}")
                println(it.country.name)
                println(it.seasons[0].name)
            }
        })
    }
}