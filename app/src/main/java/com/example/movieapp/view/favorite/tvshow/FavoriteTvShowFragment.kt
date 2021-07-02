package com.example.movieapp.view.favorite.tvshow


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.movieapp.R
import com.example.movieapp.adapter.TvShowAdapter
import com.example.movieapp.model.TvShow
import com.example.movieapp.view.favorite.movie.FavoriteMovieFragment
import kotlinx.android.synthetic.main.fragment_favorite_tv_show.*

/**
 * A simple [Fragment] subclass.
 */
class FavoriteTvShowFragment(private val onItemClickListener: OnItemClickListener) : Fragment() {
    companion object {
        val TAG = FavoriteMovieFragment::class.java.simpleName
    }

    private lateinit var favoriteTvShowViewModel: FavoriteTvShowViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_tv_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoriteTvShowViewModel = ViewModelProvider(this).get(FavoriteTvShowViewModel::class.java)

        initRecyclerView()
        subscribeUI()
    }

    private fun subscribeUI() {
        favoriteTvShowViewModel.favoriteMovies.observe(viewLifecycleOwner, Observer {
            showMovieInRecyclerView(it)
        })
    }

    private fun initRecyclerView() {
        rv_movie.layoutManager = LinearLayoutManager(context)
        rv_movie.setHasFixedSize(true)
    }

    private fun showMovieInRecyclerView(tvShowList: List<TvShow>) {
        val adapter = TvShowAdapter(tvShowList)
        adapter.onItemClick = {
            onItemClickListener.onItemClick(it)
        }

        rv_movie.adapter = adapter
    }

    interface OnItemClickListener {
        fun onItemClick(tvShow: TvShow)
    }

}
