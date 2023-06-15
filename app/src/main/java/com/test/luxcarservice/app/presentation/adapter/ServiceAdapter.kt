package com.test.luxcarservice.app.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.luxcarservice.databinding.ItemServiceBinding
import com.test.luxcarservice.domain.model.Service

class ServiceAdapter(
    val listener: Listener,
    val role: String
) : RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder>() {

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
            if (role == "STAFF") {
                remove.apply {
                    visibility = View.VISIBLE
                    setOnClickListener {
                        listener.onRemoveClick(serviceList[position])
                    }
                }
                btnSubscribe.visibility = View.GONE
            }

            tvTitle.text = serviceList[position].name
            tvDescription.text = serviceList[position].description
            tvPrice.text = serviceList[position].price.toString()
            btnSubscribe.setOnClickListener {
                listener.onServiceClick(serviceList[position])
            }
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

    interface Listener {

        fun onRemoveClick(service: Service)
        fun onServiceClick(service: Service)
    }
}