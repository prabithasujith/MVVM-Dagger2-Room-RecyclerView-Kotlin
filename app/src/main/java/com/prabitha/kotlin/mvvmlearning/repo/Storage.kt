package com.prabitha.kotlin.mvvmlearning.repo

import androidx.lifecycle.LiveData
import com.prabitha.kotlin.mvvmlearning.models.DataModel

interface Storage {

    fun getItems(): LiveData<List<DataModel>>
    fun enterItems(item:DataModel)
}