package com.gaurav.jokesclient.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gaurav.jokesclient.domain.usecase.*

class JokesViewModelFactory(
    private val app:Application,
    private val getJokesUseCase: GetJokesUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return JokesViewModel(
            app,
            getJokesUseCase
        ) as T
    }
}









