package cl.rober.movieinfoapi.ui.moviedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import cl.rober.movieinfoapi.R
import cl.rober.movieinfoapi.databinding.FragmentMovieDetailBinding

class MovieDetailFragment : Fragment(R.layout.fragment_movie_detail) {

    private lateinit var binding: FragmentMovieDetailBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMovieDetailBinding.bind(view)
    }
}