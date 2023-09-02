package com.gaurav.jokesclient.data.repository.dataSourceImpl

import com.gaurav.jokesclient.data.db.JokesDAO
import com.gaurav.jokesclient.data.model.APIResponse
import com.gaurav.jokesclient.data.repository.dataSource.JokesLocalDataSource

class JokesLocalDataSourceImpl(
    private val jokesDAO: JokesDAO
) : JokesLocalDataSource {
    override suspend fun saveJokesToDB(apiResponse: APIResponse) {
        jokesDAO.insertWithTimestamp(apiResponse)
    }

    override fun getSavedJokes(): MutableList<APIResponse> {
        return jokesDAO.getAllArticles()
    }


}