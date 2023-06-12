package com.test.luxcarservice.app.presentation.screen.products

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.luxcarservice.R
import com.test.luxcarservice.app.app.App
import com.test.luxcarservice.app.presentation.adapter.ProductAdapter
import com.test.luxcarservice.databinding.FragmentProductsBinding
import com.test.luxcarservice.domain.model.Notification
import com.test.luxcarservice.domain.model.Product
import com.test.luxcarservice.domain.model.ShopCart
import javax.inject.Inject

class ProductsFragment : Fragment(), ProductAdapter.Listener {

    @Inject
    lateinit var productsViewModelFactory: ProductsViewModelFactory

    private lateinit var binding: FragmentProductsBinding
    private lateinit var productsViewModel: ProductsViewModel
    private lateinit var productAdapter: ProductAdapter

    private var role = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectProductsFragment(
            productsFragment = this
        )
        productsViewModel = ViewModelProvider(
            owner = this,
            factory = productsViewModelFactory
        )[ProductsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeProducts()
        onAddButtonClick(view)
        toAddService(view)
    }

    private fun addProductAdapter() {
        productAdapter = ProductAdapter(this, role)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = productAdapter
        }
    }

    private fun observeProducts() {
        productsViewModel.apply {
            role = getRoles()[getRoles().indexOf(getRoles().firstOrNull {
                it.id == getUser(getUserId()).role_id
            })].role.toString()
            if (role == "STAFF") {
                binding.add.visibility = View.VISIBLE
            }
            addProductAdapter()
            productAdapter.setProductList(getProducts())
        }
    }

    private fun onAddButtonClick(view: View) {

    }

    override fun onRemoveClick(product: Product) {
        productsViewModel.deleteProduct(product.id)
    }

    override fun onProductClick(product: Product, price: Float, count: Long) {
        productsViewModel.apply {
            val lastShopCartId = getLastShopCartId()
            val shopCart = ShopCart(
                id = getLastShopCartId() + 1L,
                user_id = getUserId(),
                product_id = product.id,
                price = price,
                count = count,
            )
            upsertShopCart(shopCart = shopCart)
            val notification = Notification(
                id = getLastNotificationId() + 1L,
                user_id = getUserId(),
                appointment_id = null,
                shopCard_id = lastShopCartId + 1L
            )
            upsertNotification(notification = notification)
            Toast.makeText(
                view?.context, resources.getString(
                    R.string.order_add,
                    product.name,
                    count,
                    price
                ), Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun toAddService(view: View) {
        binding.add.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_rootFragment_to_addProductFragment)
        }
    }
}