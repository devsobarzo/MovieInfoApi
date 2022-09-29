package cl.rober.movieinfoapi.repository

import cl.rober.movieinfoapi.data.model.MovieList
import cl.rober.movieinfoapi.data.remote.MovieDataSource

class MovieRepositoryImpl(private val dataSource: MovieDataSource) : MovieRepository {
         override suspend fun getMovies(): MovieList = dataSource.getMovies()
}