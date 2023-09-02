package com.gaurav.jokesclient.data.repository.dataSource

import com.gaurav.jokesclient.data.model.APIResponse

interface JokesLocalDataSource {
    suspend fun saveJokesToDB(apiResponse: APIResponse)
    fun getSavedJokes(): MutableList<APIResponse>


}