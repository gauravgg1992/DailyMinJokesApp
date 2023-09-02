package com.gaurav.jokesclient.data.api

import com.gaurav.jokesclient.data.model.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface JokesAPIService {
  @GET("/api")
  suspend fun getJoke(
      @Query("format")
      format:String="json",
  ): Response<APIResponse>


}