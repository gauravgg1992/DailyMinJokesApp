package com.gaurav.jokesclient.presentation.di

import android.app.Application
import com.gaurav.jokesclient.domain.usecase.*
import com.gaurav.jokesclient.presentation.viewmodel.JokesViewModelFactory
import org.koin.dsl.module


class FactoryModule {


    var factoryModule=module{
        fun provideNewsViewModelFactory(
            application: Application,
            getJokesUseCase: GetJokesUseCase,

        ):JokesViewModelFactory{
            return JokesViewModelFactory(
                application,
                getJokesUseCase
            )
        }

        single{provideNewsViewModelFactory(get(),get())}
    }


}








