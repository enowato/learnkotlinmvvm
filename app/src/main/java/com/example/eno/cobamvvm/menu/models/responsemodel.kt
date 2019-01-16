package com.example.eno.cobamvvm.menu.models
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class responsemodel(
    @SerializedName("data") @Expose
    var `data`: MutableList<Data>,
    @SerializedName("status_code") @Expose
    var statusCode: Int
) {
    data class Data(
        @SerializedName("image") @Expose
        var image: String,
        @SerializedName("location") @Expose
        var location: String,
        @SerializedName("name") @Expose
        var name: String
    )
}