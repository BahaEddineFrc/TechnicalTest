package com.lakooz.lpctest.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.lakooz.lpctest.R

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url: String?) {
    // Done added Glide
    Glide
        .with(imageView.context)
        .load(url)
        .centerCrop()
        .placeholder(R.drawable.pot_gradient_mask)
        .into(imageView)
}