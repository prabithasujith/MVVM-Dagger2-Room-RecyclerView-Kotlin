package com.prabitha.kotlin.mvvmlearning.database

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.prabitha.kotlin.mvvmlearning.models.DataModel
import javax.inject.Inject

@Dao
interface DatabaseDao  {

    @Query( "SELECT * FROM tabledata" )
    fun getDetails(): LiveData<List<DataModel>>

@Insert
fun insert(value: DataModel)

}