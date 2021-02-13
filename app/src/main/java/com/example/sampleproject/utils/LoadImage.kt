package com.example.sampleproject.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.sampleproject.R

fun ImageView.setImage(
    imageUrl: String
) {
    Glide.with(this)
        .load(imageUrl)
        .placeholder(R.mipmap.ic_launcher)
        .error(R.mipmap.ic_launcher)
        .centerCrop()
        .into(this)
}

fun ImageView.setRoundImage(
    imageUrl: String
) {
    Glide.with(this)
        .load(imageUrl)
        .placeholder(R.mipmap.ic_launcher)
        .error(R.mipmap.ic_launcher)
        .circleCrop()
        .into(this)
}