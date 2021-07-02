package com.example.movieapp.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.movieapp.model.Movie
import com.example.movieapp.model.TvShow
import com.example.movieapp.model.local.dao.FavoriteMovieDao
import com.example.movieapp.model.local.dao.FavoriteTvShowDao

@Database(entities = [Movie::class, TvShow::class], version = 1, exportSchema = false)
abstract class MovieRoomDatabase : RoomDatabase() {

    abstract fun FavoriteMovieDao(): FavoriteMovieDao

    abstract fun FavoriteTvShowDao(): FavoriteTvShowDao

    companion object {
        @Volatile
        private var INSTANCE: MovieRoomDatabase? = null

        fun getDatabase(context: Context): MovieRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MovieRoomDatabase::class.java,
                    "movie_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}