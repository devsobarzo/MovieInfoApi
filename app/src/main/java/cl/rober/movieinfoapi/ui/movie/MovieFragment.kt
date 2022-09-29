package cl.rober.movieinfoapi.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import cl.rober.movieinfoapi.R
import cl.rober.movieinfoapi.core.Resource
import cl.rober.movieinfoapi.data.model.Movie
import cl.rober.movieinfoapi.data.remote.MovieDataSource
import cl.rober.movieinfoapi.databinding.FragmentMovieBinding
import cl.rober.movieinfoapi.presentation.MovieViewModel
import cl.rober.movieinfoapi.presentation.MovieViewModelFactory
import cl.rober.movieinfoapi.repository.MovieRepositoryImpl
import cl.rober.movieinfoapi.repository.RetrofitClient
import cl.rober.movieinfoapi.ui.movie.adapter.MovieAdapter
import cl.rober.movieinfoapi.ui.movie.adapter.concat.MovieConcatAdapter

class MovieFragment : Fragment(R.layout.fragment_movie), MovieAdapter.OnMovieClickListener  {

    private lateinit var binding: FragmentMovieBinding
    private val viewModel by viewModels<MovieViewModel> { MovieViewModelFactory(
        MovieRepositoryImpl(
        MovieDataSource(
            RetrofitClient.webService
        ))
    )}

    private lateinit var concatAdapter: ConcatAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMovieBinding.bind(view)

        concatAdapter = ConcatAdapter()

        viewModel.fetchMovies().observe(viewLifecycleOwner, Observer { result ->
            when(result) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    concatAdapter.apply {
                        addAdapter(0, MovieConcatAdapter(MovieAdapter(result.data.items, this@MovieFragment)))
                    }
                    binding.rvMovies.adapter = concatAdapter
                }
                is Resource.Failure -> {
                    binding.progressBar.visibility = View.GONE
                }
            }
        })
    }

    override fun onMovieClick(movie: Movie) {
        val action = MovieFragmentDirections.actionMovieFragmentToMovieDetailFragment(
            movie.image,
            movie.image,
            movie.imDbRating,
            movie.imDbRatingCount,
            movie.plot,
            movie.fullTitle,
            movie.releaseState,
            movie.stars
        )
        findNavController().navigate(action)
    }
}
