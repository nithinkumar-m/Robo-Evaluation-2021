package com.example.sampleproject.di

import com.example.sampleproject.data.api.ApiClientImpl
import com.example.sampleproject.data.api.ApiRepository
import com.example.sampleproject.data.repository.BannerRepositoryImpl
import com.example.sampleproject.data.repository.ImageListRepositoryImpl
import com.example.sampleproject.domain.repository.BannerRepository
import com.example.sampleproject.domain.repository.ImageListRepository
import org.koin.dsl.module

val dataModule = module {
    single { ApiRepository(get()) }
    single { ApiClientImpl() }
    single<BannerRepository> { BannerRepositoryImpl(get()) }
    single<ImageListRepository> { ImageListRepositoryImpl(get()) }
}