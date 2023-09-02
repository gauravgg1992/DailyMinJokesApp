package com.gaurav.jokesclient.presentation.di

import android.app.Application
import androidx.room.Room
import com.gaurav.jokesclient.data.db.JokesDAO
import com.gaurav.jokesclient.data.db.JokesDatabase
import org.koin.dsl.module

class DataBaseModule {


    var databaseModule=module{

        fun provideJokesDatabase(app: Application): JokesDatabase {
            return Room.databaseBuilder(app, JokesDatabase::class.java, "news_db")
                .fallbackToDestructiveMigration()
                .build()
        }


        fun provideJokesDao(jokesDatabase: JokesDatabase): JokesDAO {
            return jokesDatabase.getJokesDAO()
        }

        single { provideJokesDatabase(get())}
        single{ provideJokesDao(get())}

    }



}