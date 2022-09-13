package com.example.moviehub

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.coroutines.NonDisposableHandle.parent
import java.text.FieldPosition

class MovieAdapter (private val context: Context, private val movies: List<Movie>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

    }
        val view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false:)
                // return holder
    return ViewHolder(view)
}
    override fun onBindViewHolder(holder:ViewHolder , position: Int) {
        val movie = movies[position]
        // set items based on views
        holder.bind(movie)
    }
    override fun getItemCount(): Int{
    return movies.size
}
class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val poster = itemView.findViewById<ImageView>(R.id.ivPoster)
    private val overview = itemView.findViewById<TextView>(R.id.tvOverview)
    private val movieTitle = itemView.findViewById<TextView>(R.id.tvTitle)

    fun bind(movie :Movie) {
        movieTitle.text = movie.title
        overview.text = movie.overview
        Glide.with(context).load(movie.posterImageUrl).into(poster)
    }
}
