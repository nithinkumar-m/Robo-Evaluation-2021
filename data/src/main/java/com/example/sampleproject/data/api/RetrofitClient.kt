package com.example.sampleproject.data.api

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class RetrofitClient {

    companion object {
        private const val BASE_URL = "https://api.pexels.com/v1/"
    }

    fun buildRetrofit(): ApiInterface =
        Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .build().create(ApiInterface::class.java)
}