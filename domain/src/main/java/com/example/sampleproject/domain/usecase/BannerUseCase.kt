package com.example.sampleproject.domain.usecase

import com.example.sampleproject.domain.model.BannerResponse
import com.example.sampleproject.domain.repository.BannerRepository
import io.reactivex.Flowable

class BannerUseCase(private val bannerRepository: BannerRepository) {

    fun getBanner(): Flowable<BannerResponse> = bannerRepository.getBannerDetail()
}