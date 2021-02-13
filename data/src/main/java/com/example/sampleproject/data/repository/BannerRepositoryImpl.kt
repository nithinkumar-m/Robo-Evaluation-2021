package com.example.sampleproject.data.repository

import com.example.sampleproject.data.api.ApiRepository
import com.example.sampleproject.domain.model.BannerResponse
import com.example.sampleproject.domain.repository.BannerRepository
import io.reactivex.Flowable

class BannerRepositoryImpl(
    private val apiRepository: ApiRepository
) : BannerRepository {
    override fun getBannerDetail(): Flowable<BannerResponse> {
        return apiRepository.getBannerDetails()
    }

}