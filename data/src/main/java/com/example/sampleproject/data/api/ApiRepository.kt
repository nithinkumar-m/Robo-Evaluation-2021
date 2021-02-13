package com.example.sampleproject.data.api

import com.example.sampleproject.domain.model.BannerResponse
import io.reactivex.Flowable

class ApiRepository(private val apiClientImpl: ApiClientImpl) {

    fun getBannerDetails(): Flowable<BannerResponse> = apiClientImpl.getBannerDetails()

    fun getImageList(
        searchString: String,
        pageSize: Int,
        pageNumber: Int
    ): Flowable<BannerResponse> = apiClientImpl.getImageList(searchString, pageSize, pageNumber)
}