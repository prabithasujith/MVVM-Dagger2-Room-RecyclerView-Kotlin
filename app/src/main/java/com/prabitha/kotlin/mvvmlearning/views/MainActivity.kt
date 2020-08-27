package com.prabitha.kotlin.mvvmlearning.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.prabitha.kotlin.mvvmlearning.R
import com.prabitha.kotlin.mvvmlearning.di.AppModule
import com.prabitha.kotlin.mvvmlearning.di.DaggerAppComponent
import com.prabitha.kotlin.mvvmlearning.di.RoomModule
import com.prabitha.kotlin.mvvmlearning.viewmodels.ListFragmentViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_list.listView
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModel: ListFragmentViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerAppComponent.builder()
            .appModule(AppModule(application))
            .roomModule(RoomModule(application))
            .build()
            .inject(this);
        val adapter=com.prabitha.kotlin.mvvmlearning.adapters.ListAdapter()
        listView.adapter=adapter
        listView.layoutManager=LinearLayoutManager(this)
        viewModel.entryList.observe(this, Observer {
            adapter.setData(it)
        })
        add_item.setOnClickListener { val intent = Intent(this,AddEntryActivity::class.java )
        startActivity(intent)
        }

    }





}