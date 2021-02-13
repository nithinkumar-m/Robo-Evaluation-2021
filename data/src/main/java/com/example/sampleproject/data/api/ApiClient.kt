package com.example.sampleproject.data.api

import com.example.sampleproject.domain.model.BannerResponse
import io.reactivex.Flowable

interface ApiClient {
    fun getBannerDetails(): Flowable<BannerResponse>

    fun getImageList(
        searchString: String,
        pageSize: Int,
        pageNumber: Int
    ): Flowable<BannerResponse>
}