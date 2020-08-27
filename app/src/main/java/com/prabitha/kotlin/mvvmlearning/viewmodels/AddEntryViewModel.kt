package com.prabitha.kotlin.mvvmlearning.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.prabitha.kotlin.mvvmlearning.models.DataModel
import com.prabitha.kotlin.mvvmlearning.repo.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddEntryViewModel @Inject constructor (application: Application, private var Repository: Repository) :
    AndroidViewModel(application){

    var added  =MutableLiveData<Boolean>()
    init {
        added.value =false
    }

    fun insertItem(dataModel: DataModel)
    {
        viewModelScope.launch(Dispatchers.IO) {
            Repository.enterItems(dataModel)
            added.value=true
            Log.d("database","added")
        }

    }
}