package cl.rober.movieinfoapi.data.remote

import cl.rober.movieinfoapi.application.AppConstants
import cl.rober.movieinfoapi.data.model.MovieList
import cl.rober.movieinfoapi.repository.WebService

class MovieDataSource(private val webService: WebService) {

    suspend fun getMovies(): MovieList = webService.getMovies(AppConstants.API_KEY)

}