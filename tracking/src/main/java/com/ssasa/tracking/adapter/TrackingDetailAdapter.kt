package com.ssasa.tracking.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import com.ssasa.tracking.ConfigTracking
import com.ssasa.tracking.R
import com.ssasa.tracking.databinding.ItemRvTrackingDetailBinding
import com.ssasa.tracking.pojo.GestionDetail
import java.text.SimpleDateFormat
import java.util.*

class TrackingDetailAdapter(
        private val dataList: MutableList<GestionDetail>
) : RecyclerView.Adapter<TrackingDetailAdapter.ViewHolder>() {


    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(ItemRvTrackingDetailBinding.inflate(LayoutInflater.from(context), parent, false), viewType)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(dataList[position]) {
            if (status == 1) {
                setMarker(holder, R.drawable.ic_marker_active)
                ConfigTracking.getInstance().activeDetailItem?.let { holder.itemView.setOnClickListener(it) }
            } else
                setMarker(holder, R.drawable.ic_marker_inactive)


            holder.binding.textViewDateItemTrackingDetail.text = SimpleDateFormat("dd/MM/yyyy hh:mm", Locale.getDefault()).format(date)
            holder.binding.textViewNameItemTrackingDetail.text = name
            holder.binding.textViewCommentItemTrackingDetail.text = comment
            holder.binding.textViewActorItemTrackingDetail.text = actor
        }
    }

    override fun getItemCount(): Int = dataList.size

    private fun setMarker(holder: ViewHolder, @DrawableRes drawable: Int) {
        holder.binding.timeline.marker = VectorDrawableCompat.create(context.resources, drawable, context.theme)
    }

    class ViewHolder(val binding: ItemRvTrackingDetailBinding, viewType: Int) : RecyclerView.ViewHolder(binding.root) {
        init {
            this.binding.timeline.initLine(viewType)
        }
    }
}