package com.example.tipicobundesligaapp.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.tipicobundesligaapp.R
import com.example.tipicobundesligaapp.common.di.component.DaggerAppComponent
import com.example.tipicobundesligaapp.common.util.DataState
import com.example.tipicobundesligaapp.presentation.adapter.RecyclerViewAdapter
import com.example.tipicobundesligaapp.presentation.viewmodel.LeagueInfoViewModel
import kotlinx.android.synthetic.main.activity_league_info.*
import javax.inject.Inject

class LeagueInfoActivity : AppCompatActivity() {
    
    @Inject
    lateinit var leagueInfoViewModel: LeagueInfoViewModel
    private var recyclerViewAdapter: RecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league_info)
        initDagger()

        cardView.setOnClickListener {
            leagueInfoViewModel.getLeagueStandings()
        }
        setupUI()
        fetchingData()
        oberverLiveData()
    }

    private fun initDagger() {
        DaggerAppComponent.builder().build().inject(this)
    }

    private fun setupUI() {
        rvLeagueStandings.adapter = recyclerViewAdapter
        rvLeagueStandings.layoutManager = LinearLayoutManager(this)
    }

    private fun fetchingData() {
        leagueInfoViewModel.getLeague()
        leagueInfoViewModel.getLeagueStandings()
    }

    private fun oberverLiveData() {
        oberveGetLeague()
        observeGetLeagueStandings()
    }

    private fun oberveGetLeague() {
        leagueInfoViewModel.league.observe(this, Observer { dataState ->
            dataState?.let {
                when (dataState) {
                    is DataState.Success -> {
                        val data = dataState.data.data
                        tvNameLeague.text = data.name
                        tvSession.text = data.seasons.first().name
                        tvContinentCountry.text = "${data.continent.name} - ${data.country.name}"
                        Glide.with(this).load(data.img).centerCrop().into(ivLeague)
                    }
                    is DataState.Error -> {

                    }
                    else -> {}
                }
            }
        })
    }

    private fun observeGetLeagueStandings() {
        leagueInfoViewModel.leagueStandings.observe(this, Observer { dataState ->
            dataState?.let {
                when (it) {
                    is DataState.Success -> println(it.data.data.standings.size)
                    is DataState.Error -> println(it.exception.message)
                    else -> {}
                }
            }
        })
    }
}