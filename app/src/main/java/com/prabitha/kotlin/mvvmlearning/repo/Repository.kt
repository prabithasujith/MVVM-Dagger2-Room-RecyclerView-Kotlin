package com.prabitha.kotlin.mvvmlearning.repo

import androidx.lifecycle.LiveData
import com.prabitha.kotlin.mvvmlearning.database.DatabaseDao
import com.prabitha.kotlin.mvvmlearning.models.DataModel
import dagger.Module
import dagger.Provides
import javax.inject.Inject

class Repository @Inject constructor(private val dbDao: DatabaseDao) : Storage {

    override fun getItems(): LiveData<List<DataModel>> {

      return dbDao.getDetails()

    }

    override fun enterItems(item: DataModel) {
        dbDao.insert(item)
    }
}