package com.gaurav.jokesclient.presentation.di

import com.gaurav.jokesclient.BuildConfig
import com.gaurav.jokesclient.data.api.JokesAPIService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetModule {


    var provideNetModule=module{

        fun provideRetrofit(): Retrofit {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BuildConfig.BASE_URL)
                .build()
        }


        fun provideJokesAPIService(retrofit: Retrofit):JokesAPIService{
            return retrofit.create(JokesAPIService::class.java)
        }

        single { provideRetrofit() }
        single{provideJokesAPIService(get())}
    }




}













