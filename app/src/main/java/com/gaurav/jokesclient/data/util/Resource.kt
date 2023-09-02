package com.gaurav.jokesclient.data.util

sealed class Resource<T>(
    val data: MutableList<T>? = null,
    val message: String? = null
) {
    class Success<T>(data: MutableList<T>) : Resource<T>(data)
    class Loading<T>(data: MutableList<T>? = null) : Resource<T>(data)
    class Error<T>(message: String, data: MutableList<T>? = null) : Resource<T>(data, message)
}


