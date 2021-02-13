package com.example.sampleproject.domain.repository

import com.example.sampleproject.domain.model.BannerResponse
import io.reactivex.Flowable

interface BannerRepository {
    fun getBannerDetail(): Flowable<BannerResponse>
}