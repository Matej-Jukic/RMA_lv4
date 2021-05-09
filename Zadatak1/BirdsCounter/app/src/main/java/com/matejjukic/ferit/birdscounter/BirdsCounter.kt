package com.matejjukic.ferit.birdscounter

import android.app.Application
import com.matejjukic.ferit.birdscounter.di.appModule
import com.matejjukic.ferit.birdscounter.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class BirdsCounter :Application() {
    companion object{
        lateinit var context: Application
        private set
    }

    override fun onCreate() {
        super.onCreate()
        context = this

        startKoin {
            androidContext(this@BirdsCounter)
            modules(appModule, viewModelModule)
        }
    }

}