package cl.rober.movieinfoapi.ui.moviedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import cl.rober.movieinfoapi.R
import cl.rober.movieinfoapi.databinding.FragmentMovieDetailBinding
import com.bumptech.glide.Glide

class MovieDetailFragment : Fragment(R.layout.fragment_movie_detail) {

    private lateinit var binding: FragmentMovieDetailBinding
    private val args by navArgs<MovieDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMovieDetailBinding.bind(view)

        Glide.with(requireContext()).load("${args.image}").centerCrop().into(binding.imgMovie)
        Glide.with(requireContext()).load("${args.backroundImage}").centerCrop().into(binding.imBackround)
        binding.txtDescription.text = args.overView
        binding.txtMovieTitle.text = args.title
        binding.txtActors.text = "Starring by: ${args.stars}"
        binding.txtRating.text = "${args.rating} rating"
        binding.txtRelease.text = "${args.releaseDate} release"
    }
}
