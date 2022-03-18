package com.ricaurte.movies20221.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.ricaurte.movies20221.databinding.FragmentDetailBinding
import com.ricaurte.movies20221.server.model.Movie
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private lateinit var detailViewModel: DetailViewModel
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)
        detailViewModel = ViewModelProvider(this)[DetailViewModel::class.java]
        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movie: Movie = args.movie
        with(detailBinding) {
            movieTitleTextView.text = movie.title
            releaseDateTextViex.text = movie.releaseDate
            voteAverageLabelTextView.text = movie.voteAverage.toString()
            Picasso.get().load("https://image.tmdb.org/t/p/w500" + movie.posterPath)
                .into(posterImageView)
            summaryTextViex.text = movie.overview
        }
    }
}