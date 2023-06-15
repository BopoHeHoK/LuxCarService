package com.test.luxcarservice.app.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.luxcarservice.databinding.ItemProductBinding
import com.test.luxcarservice.domain.model.Product
import com.test.luxcarservice.domain.model.Service

class ProductAdapter(
    val listener: Listener,
    val role: String
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {


    class ProductViewHolder(val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root)

    private var productList = ArrayList<Product>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        var price = 0f
        var count = 1L
        holder.binding.apply {

            if (role == "STAFF") {
                remove.apply {
                    visibility = View.VISIBLE
                    setOnClickListener {
                        listener.onRemoveClick(productList[position])
                    }
                }
                btnOrder.visibility = View.GONE
                imgMinus.visibility = View.GONE
                tvCount.visibility = View.GONE
                imgPlus.visibility = View.GONE
            }

            tvTitle.text = productList[position].name
            tvDescription.text = productList[position].description
            tvPrice.text = productList[position].price.toString()
            tvCount.text = count.toString()
            price = productList[position].price ?: 0f
            imgMinus.setOnClickListener{
                count--
                price = productList[position].price?.times(count) ?: 0f
                tvPrice.text = price.toString()
                tvCount.text = count.toString()
            }
            imgPlus.setOnClickListener {
                count++
                price = productList[position].price?.times(count) ?: 0f
                tvPrice.text = price.toString()
                tvCount.text = count.toString()
            }
            btnOrder.setOnClickListener {
                listener.onProductClick(productList[position], price, count)
                count = 0L
            }
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setProductList(productList: List<Product>) {
        this.productList = productList as ArrayList<Product>
        notifyDataSetChanged()
    }

    interface Listener {
        fun onRemoveClick(product: Product)
        fun onProductClick(product: Product, price: Float, count: Long)
    }
}