package cl.rober.movieinfoapi.repository

import cl.rober.movieinfoapi.data.model.MovieList

interface MovieRepository {
    suspend fun getMovies(): MovieList
}