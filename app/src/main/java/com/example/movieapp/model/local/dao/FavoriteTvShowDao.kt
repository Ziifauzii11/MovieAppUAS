package com.example.movieapp.model.local.dao

import androidx.room.*
import com.example.movieapp.model.Movie
import com.example.movieapp.model.TvShow

@Dao
interface FavoriteTvShowDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(tvShow: TvShow)

    @Delete
    suspend fun delete(tvShow: TvShow)

    @Query("SELECT * FROM favorite_tv_show ORDER BY popularity ASC")
    suspend fun loadAllFavoriteTvShows(): List<TvShow>

    @Query("SELECT * FROM favorite_tv_show where id=:id")
    suspend fun getTvShowById(id: Int): TvShow
}