package com.gaurav.jokesclient.presentation.di

import com.gaurav.jokesclient.domain.repository.JokesRepository
import com.gaurav.jokesclient.domain.usecase.*
import org.koin.dsl.module


class UseCaseModule {

   var useCaseModule=module{

      fun provideGetJokesListUseCase(
          jokesRepository: JokesRepository
      ):GetJokesUseCase{
         return GetJokesUseCase(jokesRepository)
      }

      single { provideGetJokesListUseCase(get()) }

   }

}


















