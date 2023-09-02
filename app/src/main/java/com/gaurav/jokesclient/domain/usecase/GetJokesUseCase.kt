package com.gaurav.jokesclient.domain.usecase

import com.gaurav.jokesclient.data.model.APIResponse
import com.gaurav.jokesclient.domain.repository.JokesRepository

class GetJokesUseCase(private val jokesRepository: JokesRepository) {

     suspend fun execute(): MutableList<APIResponse> {
        return jokesRepository.getJokeList()
    }
}