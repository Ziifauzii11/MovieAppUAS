package com.example.movieapp.model.network.response


import com.example.movieapp.model.TvShowVideo
import com.google.gson.annotations.SerializedName

data class TvShowVideoResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("results")
    val results: List<TvShowVideo>
)