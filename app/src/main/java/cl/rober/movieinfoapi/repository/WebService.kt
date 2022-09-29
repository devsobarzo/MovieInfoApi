package cl.rober.movieinfoapi.repository

import cl.rober.movieinfoapi.application.AppConstants
import cl.rober.movieinfoapi.data.model.MovieList
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("movies.json")
    suspend fun getMovies(@Query("key") apiKey: String): MovieList
}

object RetrofitClient {
    val webService by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }
}