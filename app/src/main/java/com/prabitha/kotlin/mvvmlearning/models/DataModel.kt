package com.prabitha.kotlin.mvvmlearning.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabledata")
data class DataModel(
    @PrimaryKey
    val id: Long= System.currentTimeMillis(),
    @ColumnInfo
    val time: Long,
    @ColumnInfo
    val noOfItems :Int,
    @ColumnInfo
    val entryDetail:String,
    @ColumnInfo
    val amount:Double
)