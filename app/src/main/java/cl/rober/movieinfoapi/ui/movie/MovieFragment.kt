package cl.rober.movieinfoapi.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import cl.rober.movieinfoapi.R
import cl.rober.movieinfoapi.core.Resource
import cl.rober.movieinfoapi.data.remote.MovieDataSource
import cl.rober.movieinfoapi.databinding.FragmentMovieBinding
import cl.rober.movieinfoapi.presentation.MovieViewModel
import cl.rober.movieinfoapi.presentation.MovieViewModelFactory
import cl.rober.movieinfoapi.repository.MovieRepositoryImpl
import cl.rober.movieinfoapi.repository.RetrofitClient

class MovieFragment : Fragment(R.layout.fragment_movie) {

    private lateinit var binding: FragmentMovieBinding
    private val viewModel by viewModels<MovieViewModel> { MovieViewModelFactory(
        MovieRepositoryImpl(
        MovieDataSource(
            RetrofitClient.webService
        ))
    )}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMovieBinding.bind(view)

        viewModel.fetchMovies().observe(viewLifecycleOwner, Observer { result ->
            when(result) {
                is Resource.Loading -> {
                    Log.d("LiveData", "Loading...")
                }
                is Resource.Success -> {
                    Log.d("LiveData", "${result.data}")
                }
                is Resource.Failure -> {
                    Log.d("Error", "${result.exception}")
                }
            }
        })
    }
}
