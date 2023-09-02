package com.gaurav.jokesclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gaurav.jokesclient.data.model.APIResponse

@Database(
    entities = [APIResponse::class],
    version = 2,
    exportSchema = false
)
abstract  class JokesDatabase : RoomDatabase(){
    abstract fun getJokesDAO():JokesDAO
}

