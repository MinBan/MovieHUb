package com.example.moviehub



data class MovieModel(
    val page : Int? = null,
    val results: ArrayList<MovieResults> = arrayListOf(),
    val total_page: Int? = null,
    val total_results: Int? = null
)