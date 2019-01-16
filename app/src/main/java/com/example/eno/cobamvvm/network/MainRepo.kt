package com.example.eno.cobamvvm.network
import com.example.eno.cobamvvm.menu.models.responsemodel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainRepo {
    private val apiService = ServiceFactory.create()
    private val compositeDisposable = CompositeDisposable()

    fun requestListPlace(onResult: (responsemodel) -> Unit, onError: (Throwable) -> Unit){
        apiService.getListPlace()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object: APIobs<responsemodel>(compositeDisposable){
                    override fun onApiSuccess(data: responsemodel) {
                        onResult(data)
                    }

                    override fun onApiError(er: Throwable) {
                        onError(er)
                    }
                })
    }

    fun onDestroy(){
        compositeDisposable.clear()
    }
}