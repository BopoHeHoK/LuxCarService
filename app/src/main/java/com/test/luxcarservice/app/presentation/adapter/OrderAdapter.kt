package com.test.luxcarservice.app.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.luxcarservice.databinding.ItemOrderBinding
import com.test.luxcarservice.domain.model.Product
import com.test.luxcarservice.domain.model.ShopCart
import com.test.luxcarservice.domain.model.User

class OrderAdapter : RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    class OrderViewHolder(val binding: ItemOrderBinding) :
        RecyclerView.ViewHolder(binding.root)

    private var orderList = ArrayList<ShopCart>()
    private var productList = ArrayList<Product>()
    private var userList = ArrayList<User>()

    private var email = ""
    private var phoneNumber: String? = ""

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        return OrderViewHolder(
            ItemOrderBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        holder.binding.apply {
            //товар
            tvProduct.text = productList[productList.indexOf(productList.firstOrNull {
                it.id == orderList[position].product_id
            })].name

            tvPrice.text = orderList[position].price.toString()
            tvCount.text = orderList[position].count.toString()

            //имя
            tvName.text = userList[userList.indexOf(userList.firstOrNull {
                it.id == orderList[position].user_id
            })].last_name.toString() + " " + userList[userList.indexOf(userList.firstOrNull {
                it.id == orderList[position].user_id
            })].first_name.toString()

            //контакт
            email = userList[userList.indexOf(userList.firstOrNull {
                it.id == orderList[position].user_id
            })].email.toString()
            phoneNumber = userList[userList.indexOf(userList.firstOrNull {
                it.id == orderList[position].user_id
            })].phone_number
            if (!phoneNumber.isNullOrEmpty()) {
                tvContact.text = phoneNumber
            } else {
                tvContact.text = email
            }
        }
    }

    override fun getItemCount(): Int {
        return orderList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setOrderList(orderList: List<ShopCart>) {
        this.orderList = orderList as ArrayList<ShopCart>
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