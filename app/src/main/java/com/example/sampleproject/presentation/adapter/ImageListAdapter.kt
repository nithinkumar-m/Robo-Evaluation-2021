package com.example.sampleproject.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleproject.R
import com.example.sampleproject.domain.model.Photo
import com.example.sampleproject.utils.setImage
import com.example.sampleproject.utils.setRoundImage
import kotlinx.android.synthetic.main.layout_image_list.view.*
import kotlin.properties.Delegates

class ImageListAdapter : RecyclerView.Adapter<ImageListAdapter.ViewHolder>() {

    var imageList: List<Photo> by Delegates.observable(listOf()) { _, _, _ -> notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_image_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(imageList[position])
    }

    override fun getItemCount(): Int = imageList.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindData(imageDetail: Photo) {
            imageDetail.src.original?.let { url ->
                itemView.item_image.setImage(url)
                itemView.profile_pic.setRoundImage(url)
            }
            itemView.text_photographer.text = imageDetail.photographer
        }
    }
}