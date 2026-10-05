package com.kotlintoolchain.aldikitta.di

import com.kotlintoolchain.aldikitta.repository.MovieRepositoryImpl
import com.kotlintoolchain.aldikitta.repository.MovieRepository
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module

@Module
class DataMovieModule {
    @Factory(binds = [MovieRepository::class])
    fun movieRepository() = MovieRepositoryImpl()
}