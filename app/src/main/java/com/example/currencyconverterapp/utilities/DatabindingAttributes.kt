package com.example.currencyconverterapp.utilities

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.currencyconverterapp.utilities.extensions.imageview.load


class DatabindingAttributes {
    companion object {
        @JvmStatic
        @BindingAdapter("android:src")
        fun setImageView(imageView: ImageView, imageUrl: String) {
            imageView.load(imageUrl)
        }
    }


}