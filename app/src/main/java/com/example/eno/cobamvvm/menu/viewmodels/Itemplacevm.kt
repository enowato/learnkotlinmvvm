package com.example.eno.cobamvvm.menu.viewmodels
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.example.eno.cobamvvm.menu.models.responsemodel

class Itemplacevm(model: responsemodel.Data):ViewModel() {
    var title: ObservableField<String> = ObservableField()
    var location: ObservableField<String> = ObservableField()
    var image: ObservableField<String> = ObservableField()

    init {
        title.set(model.name)
        location.set(model.location)
        image.set(model.image)
    }
}