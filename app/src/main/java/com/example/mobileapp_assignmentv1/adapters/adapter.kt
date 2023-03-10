package com.example.mobileapp_assignmentv1.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileapp_assignmentv1.databinding.LayoutOfEachFixturesBinding
import com.example.mobileapp_assignmentv1.models.Fixtures
interface adapters {
    fun fixturesClick(fixtures: Fixtures, position: Int)
}

class adapter constructor(private var listOfFixtures: List<Fixtures>,
                          private val listener: adapters) :
    RecyclerView.Adapter<adapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = LayoutOfEachFixturesBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val fixtures = listOfFixtures[holder.adapterPosition]
        holder.bind(fixtures, listener)
    }

    override fun getItemCount(): Int = listOfFixtures.size

    //Connecting the dat class field to the card textviews.
    class MainHolder(private val binding : LayoutOfEachFixturesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        //Binding assigned it to my cards texviews and toString(), converts Int to String.
        fun bind(dataClassVariables: Fixtures, listener: adapters) {
            binding.team1.text = dataClassVariables.team1
            binding.team2.text = dataClassVariables.team2
            binding.score1.text = dataClassVariables.score1.toString()
            binding.score2.text = dataClassVariables.score2.toString()
            binding.venue.text = dataClassVariables.venue
            binding.date.text = dataClassVariables.date

            binding.root.setOnClickListener { listener.fixturesClick(dataClassVariables, adapterPosition) }
        }
    }
}
