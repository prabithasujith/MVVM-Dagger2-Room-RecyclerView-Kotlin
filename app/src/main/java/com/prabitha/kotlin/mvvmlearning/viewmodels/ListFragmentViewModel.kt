package com.prabitha.kotlin.mvvmlearning.viewmodels

import android.app.Application
import androidx.lifecycle.*
import com.prabitha.kotlin.mvvmlearning.models.DataModel
import com.prabitha.kotlin.mvvmlearning.repo.Repository
import javax.inject.Inject

class ListFragmentViewModel @Inject constructor (application: Application,private var Repository: Repository) :AndroidViewModel(application){

    val entryList: LiveData<List<DataModel>>

    init {

       /* viewModelScope.launch(Dispatchers.IO) {
            repository.enterItems(DataModel(time = System.currentTimeMillis(),amount = 1000.0,entryDetail = "Grocery",noOfItems = 5))
        }*/

        entryList=Repository.getItems()
    }

    override fun onCleared() {
        super.onCleared()
    }
}