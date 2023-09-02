package com.gaurav.jokesclient.presentation.di

import com.gaurav.jokesclient.data.repository.JokesRepositoryImpl
import com.gaurav.jokesclient.data.repository.dataSource.JokesLocalDataSource
import com.gaurav.jokesclient.data.repository.dataSource.JokesRemoteDataSource
import com.gaurav.jokesclient.domain.repository.JokesRepository
import org.koin.dsl.module


class RepositoryModule {

 var repositoryModule=module{

     fun provideJokesRepository(
         jokesRemoteDataSource: JokesRemoteDataSource,
         jokesLocalDataSource: JokesLocalDataSource
     ): JokesRepository {
         return JokesRepositoryImpl(
             jokesRemoteDataSource,
             jokesLocalDataSource
         )
     }

     single{provideJokesRepository(get(),get())}
 }


}














