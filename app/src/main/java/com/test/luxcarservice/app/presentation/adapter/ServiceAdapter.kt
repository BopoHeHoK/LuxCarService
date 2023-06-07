package com.test.luxcarservice.app.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.luxcarservice.databinding.ItemServiceBinding
import com.test.luxcarservice.domain.model.Service

class ServiceAdapter : RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder>() {

    class ServiceViewHolder(val binding: ItemServiceBinding) :
        RecyclerView.ViewHolder(binding.root)

    private var serviceList = ArrayList<Service>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        return ServiceViewHolder(
            ItemServiceBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        holder.binding.apply {
            tvTitle.text = serviceList[position].name
            tvDescription.text = serviceList[position].description
        }
    }

    override fun getItemCount(): Int {
        return serviceList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setServiceList(serviceList: List<Service>) {
        this.serviceList = serviceList as ArrayList<Service>
        notifyDataSetChanged()
    }
}