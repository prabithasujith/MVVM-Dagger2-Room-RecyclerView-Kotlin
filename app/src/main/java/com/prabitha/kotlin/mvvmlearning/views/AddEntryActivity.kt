package com.prabitha.kotlin.mvvmlearning.views

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.prabitha.kotlin.mvvmlearning.R
import com.prabitha.kotlin.mvvmlearning.di.AppModule
import com.prabitha.kotlin.mvvmlearning.di.DaggerAppComponent
import com.prabitha.kotlin.mvvmlearning.di.RoomModule
import com.prabitha.kotlin.mvvmlearning.models.DataModel
import com.prabitha.kotlin.mvvmlearning.viewmodels.AddEntryViewModel
import kotlinx.android.synthetic.main.fragment_add_detail.*
import kotlinx.android.synthetic.main.list_item.*
import javax.inject.Inject

class AddEntryActivity : AppCompatActivity() {

    @Inject
    lateinit var addEntryViewModel: AddEntryViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_add_detail)

        DaggerAppComponent.builder()
            .appModule(AppModule(application))
            .roomModule(RoomModule(application))
            .build()
            .inject(this);
        addEntryViewModel.added.observe(this, Observer {
            if(it)
                finish()
        })

        add.setOnClickListener { addEntryViewModel.insertItem(DataModel(noOfItems =  numberOfItems.text.toString().toInt() as Int  ,entryDetail = detail.text.toString() ,amount = amount.text.toString().toDouble() ,time = System.currentTimeMillis())   ) }

    }



}