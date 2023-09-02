package com.gaurav.jokesclient.data.repository.dataSourceImpl

import com.gaurav.jokesclient.data.api.JokesAPIService
import com.gaurav.jokesclient.data.model.APIResponse
import com.gaurav.jokesclient.data.repository.dataSource.JokesRemoteDataSource
import retrofit2.Response

class JokesRemoteDataSourceImpl(
        private val jokesAPIService: JokesAPIService
):JokesRemoteDataSource {
    override suspend fun getJokesList(): Response<APIResponse> {
          return jokesAPIService.getJoke()
    }

}