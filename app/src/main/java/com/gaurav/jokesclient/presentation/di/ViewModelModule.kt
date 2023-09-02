package com.gaurav.jokesclient.presentation.di

import com.gaurav.jokesclient.presentation.viewmodel.JokesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class ViewModelModule {

    var viewModelModule=module{

        viewModel { JokesViewModel(get(),get()) }
    }
}