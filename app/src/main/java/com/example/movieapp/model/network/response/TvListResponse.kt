package com.example.movieapp.model.network.response


import com.example.movieapp.model.TvShow
import com.google.gson.annotations.SerializedName

data class TvListResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<TvShow>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)