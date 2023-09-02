package com.gaurav.jokesclient.presentation.di

import com.gaurav.jokesclient.data.api.JokesAPIService
import com.gaurav.jokesclient.data.repository.dataSource.JokesRemoteDataSource
import com.gaurav.jokesclient.data.repository.dataSourceImpl.JokesRemoteDataSourceImpl
import org.koin.dsl.module


class RemoteDataModule {
    var remoteDataModule=module{
        fun provideJokesRemoteDataSource(
            jokesAPIService: JokesAPIService
        ):JokesRemoteDataSource{
            return JokesRemoteDataSourceImpl(jokesAPIService)
        }

        single { provideJokesRemoteDataSource(get()) }
    }


}












