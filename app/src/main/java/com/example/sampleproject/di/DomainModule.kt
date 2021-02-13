package com.example.sampleproject.di

import com.example.sampleproject.domain.usecase.BannerUseCase
import com.example.sampleproject.domain.usecase.ImageListUseCase
import org.koin.dsl.module

val domainModule = module {
    single { BannerUseCase(get()) }
    single { ImageListUseCase(get()) }
}