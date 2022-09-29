package cl.rober.movieinfoapi.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import cl.rober.movieinfoapi.R
import cl.rober.movieinfoapi.databinding.FragmentMovieBinding

class MovieFragment : Fragment(R.layout.fragment_movie) {

    private lateinit var binding: FragmentMovieBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMovieBinding.bind(view)
    }
}