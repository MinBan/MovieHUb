package com.example.moviehub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.RequestParams
import com.example.moviehub.RequestHandler
import com.example.moviehub.http.RequestHandler
import com.example.moviehub.model.results.PersonResults
import com.example.moviehub.rView.PersonAdapter
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private val gson = Gson()
    private val client = AsyncHttpClient()
    private val params = RequestParams()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // person logic
        val personRV = findViewById<RecyclerView>(R.id.trending_people_RV)
        RequestHandler.getTrendingPeople(personRV)

        // movie logic
        val movieRV = findViewById<RecyclerView>(R.id.trending_movie_RV)
        LinearLayoutManager(this).also { movieRV.layoutManager = it }
        RequestHandler.getTrendingMovies(movieRV)
    }

    private fun LinearLayoutManager(mainActivity: MainActivity): LinearLayoutManager {

    }
}