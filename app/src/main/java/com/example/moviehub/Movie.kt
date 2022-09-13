package com.example.moviehub

import android.os.Parcel
import org.json.JSONArray

data class Movie(
    val movieId: Parcel,
    val posterPath: String,
    val title: String,
    val overview:String
) {
    val posterImageUrl = "https://image.tmdb.org/t/p/w500/$posterPath"

    companion object {
        fun fromJsonArray(movieJSONArray: JSONArray): List<Movie> {
            val movies = mutableListOf<Movie>()

            for (i in 0 until movieJSONArray.length()) {
                val movieJson = movieJSONArray.getJSONObject(i)

                movies.add(
                    Movie(
                        movieJson.getInt("id"),
                        movieJson.getString("poster_path"),
                        movieJson.getString("title"),
                        movieJson.getString("overview")
                    )
                )
            }
            return movies
        }
    }
}