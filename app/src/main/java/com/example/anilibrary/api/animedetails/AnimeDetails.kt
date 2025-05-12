package com.example.anilibrary.api.animedetails

data class AnimeDetails(
    val trailerUrl: String,
    val images: List<Jpg>,
    val title: String,
    val synopsis: String,
    val genres: List<Genres>,
    val broadCast: BroadCast,
    val numberOfEpisodes: Int,
    val rating: Double,
)

data class Jpg(
    val imageUrl: String,
    val smallImageUrl: String,
    val largeImageUrl: String
)

data class BroadCast(
    val day: String,
    val time: String,
    val timezone: String,
    val string: String,
)

data class Genres(
    val mal_id: Int,
    val type: String,
    val name: String,
    val url: String
)