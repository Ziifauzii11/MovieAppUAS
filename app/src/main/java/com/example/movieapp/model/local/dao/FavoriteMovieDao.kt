package com.example.movieapp.model.local.dao

import android.database.Cursor
import android.net.Uri
import androidx.room.*
import com.example.movieapp.model.Movie

@Dao
interface FavoriteMovieDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(favoriteMovie: Movie)

    @Delete
    suspend fun delete(favoriteMovie: Movie)

    @Query("SELECT * FROM favorite_movie ORDER BY popularity ASC")
    suspend fun loadAllFavoriteMovies(): List<Movie>

    @Query("SELECT * FROM favorite_movie where id=:id")
    suspend fun getMovieById(id: Int): Movie

    @Query("SELECT * FROM favorite_movie")
    fun loadAllFavoriteMoviesCursor(): Cursor
}