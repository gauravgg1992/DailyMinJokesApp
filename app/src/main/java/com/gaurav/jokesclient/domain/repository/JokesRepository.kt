package com.gaurav.jokesclient.domain.repository

import com.gaurav.jokesclient.data.model.APIResponse

interface JokesRepository{

       suspend fun getJokeList(): MutableList<APIResponse>
      fun getSavedJokes(): List<APIResponse>




}