package com.example.sampleproject.data.api

import com.example.sampleproject.domain.model.BannerResponse
import io.reactivex.Flowable

class ApiClientImpl : ApiClient, RetrofitClient() {

    private val retrofit: ApiInterface = buildRetrofit()
    override fun getBannerDetails(): Flowable<BannerResponse> = retrofit.getBannerDetails()

    override fun getImageList(
        searchString: String,
        pageSize: Int,
        pageNumber: Int
    ): Flowable<BannerResponse> = retrofit.getImageList(searchString, pageSize, pageNumber)
}