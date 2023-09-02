package com.gaurav.jokesclient.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.*
import com.gaurav.jokesclient.data.model.APIResponse
import com.gaurav.jokesclient.data.util.Resource
import com.gaurav.jokesclient.domain.usecase.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception

class JokesViewModel(
    private val app:Application,
    private val getJokesUseCase: GetJokesUseCase

) : AndroidViewModel(app) {
    val jokesList: MutableLiveData<Resource<APIResponse>> = MutableLiveData()

    fun getJokesList() = viewModelScope.launch(Dispatchers.IO) {
        while(true) {
            jokesList.postValue(Resource.Loading())
            try {
                if (isNetworkAvailable(app)) {

                    val apiResult = getJokesUseCase.execute()
                    jokesList.postValue(Resource.Success(apiResult))
                } else {
                    jokesList.postValue(Resource.Error("Internet is not available"))
                }

            } catch (e: Exception) {
                jokesList.postValue(Resource.Error(e.message.toString()))
            }

            delay(5000)
        }

    }

    private fun isNetworkAvailable(context: Context?):Boolean{
        if (context == null) return false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false

    }






}














