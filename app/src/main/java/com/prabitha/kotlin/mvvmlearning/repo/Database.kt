package com.prabitha.kotlin.mvvmlearning.repo

import androidx.room.Database
import androidx.room.RoomDatabase
import com.prabitha.kotlin.mvvmlearning.database.DatabaseDao
import com.prabitha.kotlin.mvvmlearning.models.DataModel


@Database(entities = [DataModel::class],version = 1,exportSchema = false)
abstract class DetailsDatabase :RoomDatabase() {

    abstract fun databaseDao() : DatabaseDao

            }