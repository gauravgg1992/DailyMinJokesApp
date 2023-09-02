package com.gaurav.jokesclient.presentation.di

import com.gaurav.jokesclient.data.db.JokesDAO
import com.gaurav.jokesclient.data.repository.dataSource.JokesLocalDataSource
import com.gaurav.jokesclient.data.repository.dataSourceImpl.JokesLocalDataSourceImpl

import org.koin.dsl.module


class LocalDataModule {

    var localDataModule =   module{

            fun provideLocalDataSource(jokesDAO: JokesDAO): JokesLocalDataSource {
                return JokesLocalDataSourceImpl(jokesDAO)
            }

        single { provideLocalDataSource(get()) }
    }


}













