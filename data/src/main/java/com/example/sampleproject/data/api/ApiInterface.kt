package com.example.sampleproject.data.api

import com.example.sampleproject.domain.model.BannerResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {

    @Headers("Authorization: $AUTH_KEY")
    @GET("curated")
    fun getBannerDetails(): Flowable<BannerResponse>


    @Headers("Authorization: $AUTH_KEY")
    @GET("curated")
    fun getImageList(
        @Query("query") searchString: String,
        @Query("per_page") pageSize: Int,
        @Query("page") pageNumber: Int
    ): Flowable<BannerResponse>

    companion object {
        const val AUTH_KEY = "563492ad6f9170000100000177ee70048cff42a0b15362ed5d3226d7"
    }
}

