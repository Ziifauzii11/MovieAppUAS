package com.example.movieapp.view.favorite.tvshow

import android.app.Application
import androidx.lifecycle.*
import com.example.movieapp.model.Movie
import com.example.movieapp.model.TvShow
import com.example.movieapp.model.local.MovieRoomDatabase
import kotlinx.coroutines.launch

class FavoriteTvShowViewModel(application: Application) : AndroidViewModel(application) {

    private val movieRoomDatabase: MovieRoomDatabase = MovieRoomDatabase.getDatabase(application)

    private val _favoriteMovies: MutableLiveData<List<TvShow>> = MutableLiveData()
    val favoriteMovies: LiveData<List<TvShow>>
        get() = _favoriteMovies

    init {
        getFavoriteTvShows()
    }

    fun getFavoriteTvShows() {
        viewModelScope.launch {
            val favoriteList = movieRoomDatabase.FavoriteTvShowDao().loadAllFavoriteTvShows()
            _favoriteMovies.postValue(favoriteList)
        }
    }

}