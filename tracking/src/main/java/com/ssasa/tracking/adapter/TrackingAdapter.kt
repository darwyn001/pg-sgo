package com.ssasa.tracking.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ssasa.tracking.databinding.ItemRvTrackingBinding
import com.ssasa.tracking.interfaces.OnItemClickListener
import com.ssasa.tracking.pojo.Gestion

class TrackingAdapter(
        private val dataList: MutableList<Gestion>,
        private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<TrackingAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemRvTrackingBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(dataList[position]) {
                binding.textViewNumeroGestionTracking.text = numberGestion.toString()
                binding.textViewNombreClienteTracking.text = clientName
                binding.textViewEstadoGestionTracking.text = statusDescription

                dataList[position].getStatus(statusGestion, binding.imageViewStatus)

                holder.itemView.setOnClickListener {
                    onItemClickListener.OnItemClickListener(it, dataList[position])
                }
            }
        }
    }

    override fun getItemCount() = dataList.size

    fun addItems(newData: MutableList<Gestion>) {
        this.dataList.addAll(newData)
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemRvTrackingBinding) : RecyclerView.ViewHolder(binding.root)
}

