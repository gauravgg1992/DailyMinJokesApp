package com.gaurav.jokesclient.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "jokes")
data class APIResponse(

    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    @SerializedName("joke")
    val joke: String,
    @SerializedName("created_at")
    var createdAt:Long

)