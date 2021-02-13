package com.example.sampleproject.data.repository

import com.example.sampleproject.data.api.ApiRepository
import com.example.sampleproject.domain.model.BannerResponse
import com.example.sampleproject.domain.repository.ImageListRepository
import io.reactivex.Flowable

class ImageListRepositoryImpl(private val apiRepository: ApiRepository) : ImageListRepository {
    override fun getImageList(
        searchString: String,
        pageSize: Int,
        pageNumber: Int
    ): Flowable<BannerResponse> {
        return apiRepository.getImageList(searchString, pageSize, pageNumber)
    }
}