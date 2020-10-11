package com.example.tipicobundesligaapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tipicobundesligaapp.common.data.remote.model.getleaguestandings.Standing
import com.example.tipicobundesligaapp.presentation.viewholder.RecyclerViewViewHolder

class RecyclerViewAdapter(private val list: List<Standing>) : RecyclerView.Adapter<RecyclerViewViewHolder>() {

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return RecyclerViewViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: RecyclerViewViewHolder, position: Int) {
        val standing: Standing = list[position]
        holder.bind(standing)
    }

}