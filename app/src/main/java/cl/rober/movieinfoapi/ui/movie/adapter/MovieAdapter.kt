package cl.rober.movieinfoapi.ui.movie.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import cl.rober.movieinfoapi.core.BaseViewHolder
import cl.rober.movieinfoapi.data.model.Movie
import cl.rober.movieinfoapi.databinding.MovieItemBinding
import com.bumptech.glide.Glide

class MovieAdapter (private val movieList: List<Movie>,
                    private val itemClickListener: OnMovieClickListener
): RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnMovieClickListener {
        fun onMovieClick(movie: Movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = MovieViewHolder(itemBinding, parent.context)

        itemBinding.root.setOnClickListener {
            val position = holder.bindingAdapterPosition.takeIf { it!= DiffUtil.DiffResult.NO_POSITION }
                ?: return@setOnClickListener
            itemClickListener.onMovieClick(movieList[position])
        }
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is MovieViewHolder -> holder.bind(movieList[position])
        }
    }

    override fun getItemCount(): Int = movieList.size

    private inner class MovieViewHolder(val binding: MovieItemBinding,
                                        val context: Context
    ): BaseViewHolder<Movie>(binding.root){
        override fun bind(items: Movie) {
            binding.txtTitle.text = items.title
            binding.txtData.text = items.releaseState
            Glide.with(context).load("${items.image}").centerCrop().into(binding.imgMovie)

        }
    }

}
