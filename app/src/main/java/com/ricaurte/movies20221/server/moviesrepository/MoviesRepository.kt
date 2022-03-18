package com.ricaurte.movies20221.server.moviesrepository

import com.ricaurte.movies20221.server.MovieDB

class MoviesRepository {

    private val apiKey = "9b4287245d23bf769e8929f2a6c15328"

    suspend fun getMovies() = MovieDB.retrofit.getTopRated(apiKey)

}