package ru.asshands.softwire.tsykunovvkappclient.presentation.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide

fun ViewGroup.inflate(@LayoutRes layout: Int, attachToRoot: Boolean = false): View =
    LayoutInflater.from(context).inflate(layout, this, attachToRoot)

fun ImageView.loadImage(url: String) {
    Glide
        .with(this)
        .load(url)
        .into(this)
}