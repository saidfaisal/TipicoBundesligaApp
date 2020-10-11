package com.example.tipicobundesligaapp.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.tipicobundesligaapp.R
import com.example.tipicobundesligaapp.common.di.component.DaggerAppComponent
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
        leagueInfoViewModel.league.observe(this, Observer { leagueModel ->
            leagueModel?.let {
                tvNameLeague.text = it.name
                tvSession.text = it.seasons.first().name
                tvContinentCountry.text = "${it.continent.name} - ${it.country.name}"
                Glide.with(this).load(it.img).centerCrop().into(ivLeague)
            }
        })
    }

    private fun observeGetLeagueStandings() {
        leagueInfoViewModel.leagueStandings.observe(this, Observer { leagueStandingsModel ->
            leagueStandingsModel?.let {
                println(leagueStandingsModel.standings)
            }
        })
    }
}