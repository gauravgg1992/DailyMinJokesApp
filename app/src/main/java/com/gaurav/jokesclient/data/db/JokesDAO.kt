package com.gaurav.jokesclient.data.db

import androidx.room.*
import com.gaurav.jokesclient.data.model.APIResponse

@Dao
interface JokesDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(apiResponse: APIResponse)
  suspend  fun insertWithTimestamp(apiResponse: APIResponse) {
        insert(apiResponse.apply{
            createdAt = System.currentTimeMillis()
        })
    }
    @Query("SELECT * FROM jokes ORDER BY id DESC limit 10")
    fun getAllArticles(): MutableList<APIResponse>

    @Delete
    suspend fun deleteArticle(apiResponse: APIResponse)



}