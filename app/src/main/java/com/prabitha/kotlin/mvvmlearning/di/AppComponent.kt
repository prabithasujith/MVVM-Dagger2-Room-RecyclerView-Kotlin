package com.prabitha.kotlin.mvvmlearning.di

import android.app.Application
import com.prabitha.kotlin.mvvmlearning.database.DatabaseDao
import com.prabitha.kotlin.mvvmlearning.repo.DetailsDatabase
import com.prabitha.kotlin.mvvmlearning.repo.Repository
import com.prabitha.kotlin.mvvmlearning.views.AddEntryActivity
import com.prabitha.kotlin.mvvmlearning.views.MainActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [RoomModule::class, AppModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)
    fun inject(activity: AddEntryActivity)

    fun productDao(): DatabaseDao

    fun demoDatabase(): DetailsDatabase

    fun productRepository(): Repository

    fun application(): Application

}