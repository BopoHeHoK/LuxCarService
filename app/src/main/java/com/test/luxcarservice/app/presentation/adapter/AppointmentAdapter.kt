package com.test.luxcarservice.app.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.luxcarservice.databinding.ItemAppointmentBinding
import com.test.luxcarservice.domain.model.Appointment
import com.test.luxcarservice.domain.model.Service
import com.test.luxcarservice.domain.model.User

class AppointmentAdapter : RecyclerView.Adapter<AppointmentAdapter.AppointmentViewHolder>() {

    class AppointmentViewHolder(val binding: ItemAppointmentBinding) :
        RecyclerView.ViewHolder(binding.root)

    private var appointmentList = ArrayList<Appointment>()
    private var serviceList = ArrayList<Service>()
    private var userList = ArrayList<User>()

    private var email = ""
    private var phoneNumber = ""

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppointmentViewHolder {
        return AppointmentViewHolder(
            ItemAppointmentBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: AppointmentViewHolder, position: Int) {
        holder.binding.apply {
            //услуга
            tvService.text = serviceList[serviceList.indexOf(serviceList.firstOrNull {
                it.id == appointmentList[position].service_id
            })].name

            tvDate.text = appointmentList[position].date
            tvTime.text = appointmentList[position].time

            tvPrice.text = serviceList[serviceList.indexOf(serviceList.firstOrNull {
                it.id == appointmentList[position].service_id
            })].price.toString()

            //имя
            tvName.text = userList[userList.indexOf(userList.firstOrNull {
                it.id == appointmentList[position].user_id
            })].last_name.toString() + " " + userList[userList.indexOf(userList.firstOrNull {
                it.id == appointmentList[position].user_id
            })].first_name.toString()

            //контакт
            email = userList[userList.indexOf(userList.firstOrNull {
                it.id == appointmentList[position].user_id
            })].email.toString()
            phoneNumber = userList[userList.indexOf(userList.firstOrNull {
                it.id == appointmentList[position].user_id
            })].phone_number.toString()
            if (!phoneNumber.isNullOrEmpty()) {
                tvContact.text = phoneNumber
            } else {
                tvContact.text = email
            }
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

    @SuppressLint("NotifyDataSetChanged")
    fun setServiceList(serviceList: List<Service>) {
        this.serviceList = serviceList as ArrayList<Service>
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setUserList(userList: List<User>) {
        this.userList = userList as ArrayList<User>
        notifyDataSetChanged()
    }
}