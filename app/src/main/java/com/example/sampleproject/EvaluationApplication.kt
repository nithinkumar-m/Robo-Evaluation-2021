package com.example.sampleproject

import android.app.Application
import com.example.sampleproject.di.Dependency.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class EvaluationApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@EvaluationApplication)
            modules(appModule)
        }
    }
}