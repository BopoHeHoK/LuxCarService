package com.test.luxcarservice.app.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.luxcarservice.databinding.ItemNotificationBinding
import com.test.luxcarservice.domain.model.Appointment
import com.test.luxcarservice.domain.model.Notification
import com.test.luxcarservice.domain.model.Product
import com.test.luxcarservice.domain.model.ShopCart
import com.test.luxcarservice.domain.model.User

class NotificationAdapter(
    val role: String
) : RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {

    class NotificationViewHolder(val binding: ItemNotificationBinding) :
        RecyclerView.ViewHolder(binding.root)

    private var notificationList = ArrayList<Notification>()
    private var appointmentList = ArrayList<Appointment>()
    private var orderList = ArrayList<ShopCart>()
    private var userList = ArrayList<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        return NotificationViewHolder(
            ItemNotificationBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.binding.apply {
            if (role == "STAFF") {
                if (notificationList[position].appointment_id != null) {
                    tvNotification.text = ""
                } else if (notificationList[position].shopCard_id != null) {
                    tvNotification.text = ""
                }
            } else {
                if (notificationList[position].appointment_id != null) {
                    tvNotification.text = ""
                } else if (notificationList[position].shopCard_id != null) {
                    tvNotification.text = ""
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return notificationList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNotificationList(notificationList: List<Notification>) {
        this.notificationList = notificationList as ArrayList<Notification>
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setAppointmentList(appointmentList: List<Appointment>) {
        this.appointmentList = appointmentList as ArrayList<Appointment>
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setOrderList(orderList: List<ShopCart>) {
        this.orderList = orderList as ArrayList<ShopCart>
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setUserList(userList: List<User>) {
        this.userList = userList as ArrayList<User>
        notifyDataSetChanged()
    }
}