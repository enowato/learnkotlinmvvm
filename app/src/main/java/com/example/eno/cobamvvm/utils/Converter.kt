package com.example.eno.cobamvvm.utils
import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.RequestOptions
import com.example.eno.cobamvvm.R

class Converter {
    companion object {
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imageView: ImageView, url: String){
            Glide.with(imageView.context)
                    .load(url)
                    .apply(RequestOptions()
                            .placeholder(R.drawable.gitkraken)
                            .error(R.drawable.gitkraken)
                            .format(DecodeFormat.PREFER_ARGB_8888))
                    .into(imageView)
        }
    }
}