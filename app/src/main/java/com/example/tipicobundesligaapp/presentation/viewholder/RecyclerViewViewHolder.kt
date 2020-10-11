package com.example.tipicobundesligaapp.presentation.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tipicobundesligaapp.R
import com.example.tipicobundesligaapp.common.data.remote.model.getleaguestandings.Standing
import kotlinx.android.synthetic.main.item_recyclerview.view.*

class RecyclerViewViewHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(R.layout.item_recyclerview, parent, false)) {

    fun bind(standing: Standing) {
        itemView.tvNameStanding.text = standing.teamName
        itemView.tvWonDrawLost.text = "Won: ${standing.overall.won} || Draw: ${standing.overall.draw} || Lost: ${standing.overall.lost}"
        itemView.tvPoints.text = standing.overall.points
        itemView.tvPosition.text = standing.overall.position
    }
}