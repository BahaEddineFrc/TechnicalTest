package com.lakooz.lpctest.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.lakooz.lpctest.R

@BindingAdapter("android:imageUrl")
fun setImageUrl(imageView: ImageView, url: String?) {
    // Done added Glide
    if (url == null) {
        imageView.setImageResource(R.drawable.ic_launcher_background)
    } else {
        Glide
            .with(imageView.context)
            .load(url)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(imageView)
    }
}