package com.example.sampleproject.domain.usecase

import com.example.sampleproject.domain.model.BannerResponse
import com.example.sampleproject.domain.repository.ImageListRepository
import io.reactivex.Flowable

class ImageListUseCase(private val imageListRepository: ImageListRepository) {

    fun getImageList(
        searchString: String,
        pageSize: Int,
        pageNumber: Int
    ): Flowable<BannerResponse> = imageListRepository.getImageList(searchString, pageSize, pageNumber)
}