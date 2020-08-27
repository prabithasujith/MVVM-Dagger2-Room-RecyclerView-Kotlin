package com.prabitha.kotlin.mvvmlearning.di

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.prabitha.kotlin.mvvmlearning.database.DatabaseDao
import com.prabitha.kotlin.mvvmlearning.models.DataModel
import com.prabitha.kotlin.mvvmlearning.repo.DetailsDatabase
import com.prabitha.kotlin.mvvmlearning.repo.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule(application: Application){

    private var database: DetailsDatabase = Room.databaseBuilder<DetailsDatabase>(
        application,
        DetailsDatabase::class.java, "demo-db"
    ).build()



    @Provides
    fun getItems(): LiveData<List<DataModel>>? {
        return database.databaseDao().getDetails()
    }

    @Singleton
    @Provides
    fun providesRoomDatabase(): DetailsDatabase {
        return database
    }

    @Singleton
    @Provides
    fun providesProductDao(demoDatabase: DetailsDatabase): DatabaseDao{
        return demoDatabase.databaseDao()

    }

    @Singleton
    @Provides
    fun productRepository(databasedao: DatabaseDao): Repository {
       return Repository(databasedao)
    }


}