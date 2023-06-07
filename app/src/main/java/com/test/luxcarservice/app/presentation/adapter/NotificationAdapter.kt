package com.test.luxcarservice.app.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.luxcarservice.databinding.ItemNotificationBinding
import com.test.luxcarservice.domain.model.Notification

class NotificationAdapter : RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {

    class NotificationViewHolder(val binding: ItemNotificationBinding) :
        RecyclerView.ViewHolder(binding.root)

    private var notificationList = ArrayList<Notification>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        return NotificationViewHolder(
            ItemNotificationBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.binding.apply {
            tvNotification.text = notificationList[position].notification
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
}