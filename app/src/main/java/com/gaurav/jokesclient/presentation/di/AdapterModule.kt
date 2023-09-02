package com.gaurav.jokesclient.presentation.di

import com.gaurav.jokesclient.presentation.adapter.JokesAdapter

import org.koin.dsl.module


class AdapterModule {


  val adapterModule= module{
      fun provideJokesAdapter():JokesAdapter{
         return JokesAdapter()
      }

      single { provideJokesAdapter() }

   }



}