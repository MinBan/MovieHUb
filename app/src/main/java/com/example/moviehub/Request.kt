package com.example.moviehub

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.RequestParams
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.google.gson.Gson
import okhttp3.Headers

object RequestHandler {
    private val gson = Gson()

    fun getTrendingPeople(personRV: RecyclerView){
        val client = AsyncHttpClient()
        val params = RequestParams()

        val url = "https://api.themoviedb.org/3/tv/popular?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed&language=en-US&page=1"
        params["api_key"] = "a07e22bc18f5cb106bfe4cc1f83ad8ed"
        //params["page"] = "1"

        val listData = ArrayList<Person>()

        client.get(url, params, object: JsonHttpResponseHandler(){
            override fun onFailure(statusCode: Int, headers: Headers?, response: String?, throwable: Throwable?) {
                Log.e("Client Error","An Error Occurred During Data Retrieval" + response.toString())
            }

            override fun onSuccess(statusCode: Int, headers: Headers?, json: JSON?) {
                val jsonModel = gson.fromJson(json?.jsonObject.toString(), PersonModel::class.java)
                for(item in jsonModel.results){
                    listData.add(Person(
                        item.profile_path,
                        item.name
                    ))

                    val personAdapter = PersonAdapter(listData)
                    personRV.adapter = personAdapter
                }
            }

        })

    }

    fun getTrendingMovies(movieRV: RecyclerView){
        val client = AsyncHttpClient()
        val params = RequestParams()

        val url = "https://api.themoviedb.org/3/trending/movie/day"
        params["api_key"] = "a07e22bc18f5cb106bfe4cc1f83ad8ed"
        //params["page"] = "1"

        val listData = ArrayList<Movie>()

        client.get(url, params, object: JsonHttpResponseHandler(){
            override fun onFailure(statusCode: Int, headers: Headers?, response: String?, throwable: Throwable?) {
                Log.e("Client Error","An Error Occurred During Data Retrieval" + response.toString())
            }

            override fun onSuccess(statusCode: Int, headers: Headers?, json: JSON?) {
                val jsonModel = gson.fromJson(json?.jsonObject.toString(), MovieModel::class.java)
                for(item in jsonModel.results) {
                    listData.add(
                        Movie(
                            item.title,
                            item.poster_path,
                            item.release_date,
                            item.vote_average,
                            item.overview,
                            item.popularity.toString(),
                            item.show
                        )
                    )

                    val movieAdapter = MovieAdapter(listData)
                    movieRV.adapter = movieAdapter
                }
            }

        })
    }
