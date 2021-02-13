package com.example.sampleproject.domain.model

data class BannerResponse(
    val photos: List<Photo>
)

data class Photo(
    val url: String,
    val photographer: String,
    val src: Src
)

data class Src(
    val original: String,
    val large2X: String,
    val large: String,
    val medium: String,
    val small: String,
    val portrait: String,
    val landscape: String,
    val tiny: String
)
