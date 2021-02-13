package com.example.sampleproject.di

object Dependency {
    val appModule = listOf(
        dataModule,
        domainModule,
        presentationModule
    )
}