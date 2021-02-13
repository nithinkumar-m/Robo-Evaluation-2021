package com.example.sampleproject.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sampleproject.domain.model.Photo
import com.example.sampleproject.domain.usecase.BannerUseCase
import com.example.sampleproject.domain.usecase.ImageListUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class HomeViewModel(
    private val bannerUseCase: BannerUseCase,
    private val imageListUseCase: ImageListUseCase
) : ViewModel() {

    val bannerDetails: LiveData<Photo> get() = _bannerDetails
    private val _bannerDetails = MutableLiveData<Photo>()

    val imageListLiveData: LiveData<List<Photo>> get() = _imageListLiveData
    private val _imageListLiveData = MutableLiveData<List<Photo>>()

    private val compositeDisposable = CompositeDisposable()

    fun getBannerImage() {
        bannerUseCase.getBanner()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { bannerResponse ->
                bannerResponse.photos[0]
            }
            .subscribe(::onSuccess, ::onError).addTo(compositeDisposable)
    }

    fun getImageList(pageSize: Int) {
        imageListUseCase.getImageList(INITIAL_SEARCH_STRING, pageSize, PAGE_NUMBER)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { bannerResponse ->
                bannerResponse.photos
            }
            .subscribe(::onImageListApiSuccess, ::onError).addTo(compositeDisposable)
    }

    private fun onError(throwable: Throwable) {
        //error handle
    }

    private fun onSuccess(bannerDetail: Photo) {
        _bannerDetails.value = bannerDetail
    }

    private fun onImageListApiSuccess(imageList: List<Photo>) {
        _imageListLiveData.value = imageList
    }

    fun search(query: String) {
        if (query.isEmpty() || query.length >= SEARCH_TRIGGER) {
            //Handle search here can use debounce operator
        }
    }

    fun updatePage(pageSize: Int) {
        getImageList(pageSize)
    }

    companion object {
        private const val SEARCH_TRIGGER = 3
        private const val PAGE_SIZE = 20
        private const val PAGE_NUMBER = 1
        private const val INITIAL_SEARCH_STRING = "Animal"
    }
}