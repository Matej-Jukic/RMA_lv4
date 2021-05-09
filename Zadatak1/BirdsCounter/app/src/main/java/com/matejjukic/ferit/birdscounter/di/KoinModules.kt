package com.matejjukic.ferit.birdscounter.di

import com.matejjukic.ferit.birdscounter.models.BirdsCounterModel
import  com.matejjukic.ferit.birdscounter.viewmodel.BirdsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module{
    factory{BirdsCounterModel()}
}

val viewModelModule = module {
    viewModel { BirdsViewModel(get()) }
}