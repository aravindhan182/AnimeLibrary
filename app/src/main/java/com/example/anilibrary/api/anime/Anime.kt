package com.example.anilibrary.api.anime

import com.google.gson.annotations.SerializedName

data class Anime(
    @SerializedName("title")
    val title: String,
    @SerializedName("episodes")
    val numberOfEpisodes: Int?,
    @SerializedName("rating")
    val rating: String?,
    @SerializedName("images")
    val posterImage: Images
)


data class Images(
    @SerializedName("jpg")
    val jpg: Image,

    @SerializedName("webp")
    val webp: Image
)

data class Image(
    @SerializedName("image_url")
    val imageUrl: String
)

data class AnimeResponse(
    @SerializedName("data")
    val data: List<Anime>,
    @SerializedName("pagination")
    val pagination: Pagination
)

data class Pagination(
    @SerializedName("last_visible_page")
    val lastVisiblePage: Int,
    @SerializedName("has_next_page")
    val hasNextPage: Boolean
)