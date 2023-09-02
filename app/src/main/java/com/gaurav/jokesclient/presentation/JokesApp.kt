package com.gaurav.jokesclient.presentation

import android.app.Application
import com.gaurav.jokesclient.presentation.di.AdapterModule
import com.gaurav.jokesclient.presentation.di.DataBaseModule
import com.gaurav.jokesclient.presentation.di.FactoryModule
import com.gaurav.jokesclient.presentation.di.LocalDataModule
import com.gaurav.jokesclient.presentation.di.NetModule
import com.gaurav.jokesclient.presentation.di.RemoteDataModule
import com.gaurav.jokesclient.presentation.di.RepositoryModule
import com.gaurav.jokesclient.presentation.di.UseCaseModule
import com.gaurav.jokesclient.presentation.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class JokesApp : Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin {

            androidLogger(Level.DEBUG)
            androidContext(this@JokesApp)
            modules(listOf( ViewModelModule().viewModelModule,AdapterModule().adapterModule,DataBaseModule().databaseModule,FactoryModule().factoryModule,LocalDataModule().localDataModule,NetModule().provideNetModule,RemoteDataModule().remoteDataModule,RepositoryModule().repositoryModule,UseCaseModule().useCaseModule))
        }
    }
}
