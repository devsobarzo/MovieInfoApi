package cl.rober.movieinfoapi.data.model

data class Movie (
    val id: String = "",
    val title: String = "",
    val fullTitle: String = "",
    val year: String ="",
    val releaseState: String = "",
    val image: String = "",
    val runtimeStr: String = "",
    val plot: String = "",
    val contentRating: String = "",
    val imDbRating: String = "",
    val imDbRatingCount: String = "",
    val genres: String = "",
    val directors:String ="",
    val stars: String =""
)

data class MovieList(val items: List<Movie> = listOf())