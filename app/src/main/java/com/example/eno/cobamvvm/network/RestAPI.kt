package com.example.eno.cobamvvm.network
import com.example.eno.cobamvvm.menu.models.responsemodel
import io.reactivex.Observable
import retrofit2.http.GET

interface RestAPI {
    @GET("Sample.json")
    fun getListPlace(): Observable<responsemodel>
}