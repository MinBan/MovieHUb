package com.example.moviehub

package com.example.MovieHUb

import com.example.MovieHUb.model.results.TvResults

// data class for the base api response
data class Tv (
    val page : Int? = null,
    val results: ArrayList<TvResults> = arrayListOf(),
    val total_page: Int? = null,
    val total_results: Int? = null
) {
}