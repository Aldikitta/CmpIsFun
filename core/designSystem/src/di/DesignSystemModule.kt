package com.kotlintoolchain.aldikitta.di

import com.kotlintoolchain.aldikitta.screen.CmpIsFunScreenViewModel
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.Module

@Module
class DesignSystemModule {
    @KoinViewModel
    fun cmpIsFunScreenViewModel() = CmpIsFunScreenViewModel()
}