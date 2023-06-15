package com.test.luxcarservice.app.presentation.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.luxcarservice.databinding.ItemNotificationBinding
import com.test.luxcarservice.domain.model.Appointment
import com.test.luxcarservice.domain.model.Notification
import com.test.luxcarservice.domain.model.Product
import com.test.luxcarservice.domain.model.Service
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
    private var serviceList = ArrayList<Service>()
    private var productList = ArrayList<Product>()
    private var userList = ArrayList<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        return NotificationViewHolder(
            ItemNotificationBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.binding.apply {
            Log.d("kek", role)
            if (role == "STAFF") {
                if (notificationList[position].appointment_id != null) {
                    val user_id =
                        appointmentList[appointmentList.indexOf(appointmentList.firstOrNull {
                            it.id == notificationList[position].appointment_id
                        })].user_id
                    val service_id =
                        appointmentList[appointmentList.indexOf(appointmentList.firstOrNull {
                            it.id == notificationList[position].appointment_id
                        })].service_id
                    tvNotification.text =
                        "Пользователь " + userList[userList.indexOf(userList.firstOrNull {
                            it.id == user_id
                        })].first_name + " " + userList[userList.indexOf(userList.firstOrNull {
                            it.id == user_id
                        })].last_name + "(тел.: " + userList[userList.indexOf(userList.firstOrNull {
                            it.id == user_id
                        })].phone_number + ", email: " + userList[userList.indexOf(userList.firstOrNull {
                            it.id == user_id
                        })].email + ") записался на " + serviceList[serviceList.indexOf(serviceList.firstOrNull {
                            it.id == service_id
                        })].name + ", " + appointmentList[appointmentList.indexOf(appointmentList.firstOrNull {
                            it.id == notificationList[position].appointment_id
                        })].date + ", " + appointmentList[appointmentList.indexOf(appointmentList.firstOrNull {
                            it.id == notificationList[position].appointment_id
                        })].time
                } else if (notificationList[position].shopCard_id != null) {
                    val user_id = orderList[orderList.indexOf(orderList.firstOrNull {
                        it.id == notificationList[position].shopCard_id
                    })].user_id
                    val product_id = orderList[orderList.indexOf(orderList.firstOrNull {
                        it.id == notificationList[position].shopCard_id
                    })].product_id
                    tvNotification.text =
                        "Пользователь " + userList[userList.indexOf(userList.firstOrNull {
                            it.id == user_id
                        })].first_name + " " + userList[userList.indexOf(userList.firstOrNull {
                            it.id == user_id
                        })].last_name + "(тел.: " + userList[userList.indexOf(userList.firstOrNull {
                            it.id == user_id
                        })].phone_number + ", email: " + userList[userList.indexOf(userList.firstOrNull {
                            it.id == user_id
                        })].email + ") заказал " + productList[productList.indexOf(productList.firstOrNull {
                            it.id == product_id
                        })].name + ", " + orderList[orderList.indexOf(orderList.firstOrNull {
                            it.id == notificationList[position].shopCard_id
                        })].count + " шт., " + orderList[orderList.indexOf(orderList.firstOrNull {
                            it.id == notificationList[position].shopCard_id
                        })].price + " руб."
                }
            } else {
                if (notificationList[position].appointment_id != null) {
                    val service_id =
                        appointmentList[appointmentList.indexOf(appointmentList.firstOrNull {
                            it.id == notificationList[position].appointment_id
                        })].service_id
                    tvNotification.text =
                        "Вы записались на " + serviceList[serviceList.indexOf(serviceList.firstOrNull {
                            it.id == service_id
                        })].name + ", " + appointmentList[appointmentList.indexOf(appointmentList.firstOrNull {
                            it.id == notificationList[position].appointment_id
                        })].date + ", " + appointmentList[appointmentList.indexOf(appointmentList.firstOrNull {
                            it.id == notificationList[position].appointment_id
                        })].time
                } else if (notificationList[position].shopCard_id != null) {
                    val product_id = orderList[orderList.indexOf(orderList.firstOrNull {
                        it.id == notificationList[position].shopCard_id
                    })].product_id
                    tvNotification.text =
                        "Вы заказали " + productList[productList.indexOf(productList.firstOrNull {
                            it.id == product_id
                        })].name + ", " + orderList[orderList.indexOf(orderList.firstOrNull {
                            it.id == notificationList[position].shopCard_id
                        })].count + " шт., " + orderList[orderList.indexOf(orderList.firstOrNull {
                            it.id == notificationList[position].shopCard_id
                        })].price + " руб."
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
    fun setServiceList(serviceList: List<Service>) {
        this.serviceList = serviceList as ArrayList<Service>
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setProductList(productList: List<Product>) {
        this.productList = productList as ArrayList<Product>
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setUserList(userList: List<User>) {
        this.userList = userList as ArrayList<User>
        notifyDataSetChanged()
    }
}