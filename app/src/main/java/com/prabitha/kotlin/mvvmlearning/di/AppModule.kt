package com.prabitha.kotlin.mvvmlearning.di

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(val application: Application){


    @Provides
    @Singleton
    fun providesApplication(): Application {
        return application
    }
}