package com.example.itunes

import com.google.gson.annotations.SerializedName


class Results(@field:SerializedName("results") val results: List<Track>)
class Track(
    @field:SerializedName("artistName") val artist: String,
    @field:SerializedName("trackName") val name: String,
    @field:SerializedName("releaseDate") val releaseDate: String
)

