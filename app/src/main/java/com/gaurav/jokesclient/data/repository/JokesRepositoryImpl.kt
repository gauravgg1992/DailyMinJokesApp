package com.gaurav.jokesclient.data.repository

import com.gaurav.jokesclient.data.model.APIResponse
import com.gaurav.jokesclient.data.repository.dataSource.JokesLocalDataSource
import com.gaurav.jokesclient.data.repository.dataSource.JokesRemoteDataSource
import com.gaurav.jokesclient.domain.repository.JokesRepository

class JokesRepositoryImpl(
    private val jokesRemoteDataSource: JokesRemoteDataSource,
    private val jokesLocalDataSource: JokesLocalDataSource
) : JokesRepository {


    override suspend fun getJokeList(): MutableList<APIResponse> {

        return getDataFromAPi()
    }

    suspend fun getDataFromAPi(): MutableList<APIResponse> {

        var response = jokesRemoteDataSource.getJokesList()
        val body = response.body()
        if (body != null) {
            jokesLocalDataSource.saveJokesToDB(body)

        }

        return getSavedJokes()

    }

    override fun getSavedJokes(): MutableList<APIResponse> {


        return jokesLocalDataSource.getSavedJokes()

    }

}