package com.example.anilibrary.api.animedetails

import com.example.anilibrary.api.anime.Image
import com.google.gson.annotations.SerializedName

data class AnimeResponse(
    val data: AnimeDetails
)

data class AnimeDetails(
    @SerializedName("trailer")
    val trailerUrl: Trailer,
    @SerializedName("title")
    val title: String,
    @SerializedName("synopsis")
    val synopsis: String,
    @SerializedName("genres")
    val genres: List<Genres>,
    @SerializedName("episodes")
    val numberOfEpisodes: Int,
    @SerializedName("rating")
    val rating: String,
)

data class Trailer(
    @SerializedName("youtube_id")
    val youtubeId: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("embed_url")
    val embedUrl: String,
    @SerializedName("images")
    val images: Image
)


data class Genres(
    @SerializedName("mal_id")
    val animeId: Int,
    @SerializedName("type")
    val type: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)