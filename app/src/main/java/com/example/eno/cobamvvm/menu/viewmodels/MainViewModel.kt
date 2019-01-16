package com.example.eno.cobamvvm.menu.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.example.eno.cobamvvm.menu.models.responsemodel
import com.example.eno.cobamvvm.network.MainRepo

class MainViewModel (application: Application):AndroidViewModel(application) {
    private val repository = MainRepo()

    var listPlace: MutableLiveData<responsemodel> = MutableLiveData()
    var error: MutableLiveData<Throwable> = MutableLiveData()

    fun getListPlace(){
        repository.requestListPlace({
            listPlace.postValue(it)
        },{
            error.postValue(it)
        })
    }

    override fun onCleared() {
        super.onCleared()
        repository.onDestroy()
    }
}