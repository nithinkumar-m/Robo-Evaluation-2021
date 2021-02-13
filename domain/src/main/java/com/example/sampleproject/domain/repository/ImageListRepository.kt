package com.example.sampleproject.domain.repository

import com.example.sampleproject.domain.model.BannerResponse
import io.reactivex.Flowable

interface ImageListRepository {
    fun getImageList(searchString: String, pageSize: Int, pageNumber: Int): Flowable<BannerResponse>
}