package com.justin.taipeizoobrowser

import android.util.Log
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.RequestOptions
import com.justin.taipeizoobrowser.data.HomeItem
import com.justin.taipeizoobrowser.home.HomeAdapter

@BindingAdapter("homeItems")
fun bindRecyclerViewWithHomeItems(recyclerView: RecyclerView, homeItems: List<HomeItem>?) {
    homeItems?.let {
        recyclerView.adapter?.apply {
            when (this) {
                is HomeAdapter -> {
                    submitList(it)
                    Log.i("Justin", "bindRecyclerViewWithHomeItems = $it")
                }
            }
        }
    }
}

/**
 * Uses the Glide library to load an image by URL into an [ImageView]
 */
@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = it.toUri().buildUpon().build()
        GlideApp.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(com.google.android.material.R.drawable.mtrl_ic_error)
            )
            .into(imgView)
    }
}