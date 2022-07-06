package com.fahlepyrizal01.feature_home.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fahlepyrizal01.api_game.domain.model.GameModel
import com.fahlepyrizal01.feature_home.databinding.ItemGameBinding

class GameAdapter : RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    private var games = mutableListOf<GameModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(games[position])
    }

    override fun getItemCount(): Int {
        return games.size
    }

    fun updateGames(games: List<GameModel>) {
        this.games.clear()
        this.games.addAll(games)
        notifyDataSetChanged()
    }

    inner class ViewHolder(
        private val binding: ItemGameBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(game: GameModel) = with(binding) {
            Glide.with(root.context)
                .load(game.backgroundImage)
                .override(200, 300)
                .into(ivPoster)
            tvTitle.text = game.name
        }

    }

}