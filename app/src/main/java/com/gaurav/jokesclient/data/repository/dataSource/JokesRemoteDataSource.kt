package com.gaurav.jokesclient.data.repository.dataSource

import com.gaurav.jokesclient.data.model.APIResponse
import retrofit2.Response

interface JokesRemoteDataSource {
    suspend fun getJokesList():Response<APIResponse>
}