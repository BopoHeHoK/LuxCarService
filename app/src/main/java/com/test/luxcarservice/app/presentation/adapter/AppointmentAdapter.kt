package com.test.luxcarservice.app.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.luxcarservice.databinding.ItemAppointmentBinding
import com.test.luxcarservice.domain.model.Appointment

class AppointmentAdapter : RecyclerView.Adapter<AppointmentAdapter.AppointmentViewHolder>() {

    class AppointmentViewHolder(val binding: ItemAppointmentBinding) :
        RecyclerView.ViewHolder(binding.root)

    private var appointmentList = ArrayList<Appointment>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppointmentViewHolder {
        return AppointmentViewHolder(
            ItemAppointmentBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: AppointmentViewHolder, position: Int) {
        holder.binding.apply {
            tvDate.text = appointmentList[position].date
            tvTime.text = appointmentList[position].time
        }
    }

    override fun getItemCount(): Int {
        return appointmentList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setAppointmentList(appointmentList: List<Appointment>) {
        this.appointmentList = appointmentList as ArrayList<Appointment>
        notifyDataSetChanged()
    }
}