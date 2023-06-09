package com.test.luxcarservice.app.presentation.screen.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.test.luxcarservice.R
import com.test.luxcarservice.app.app.App
import com.test.luxcarservice.databinding.FragmentSplashBinding
import com.test.luxcarservice.domain.model.Product
import com.test.luxcarservice.domain.model.Role
import com.test.luxcarservice.domain.model.Service
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashFragment : Fragment() {

    @Inject
    lateinit var splashViewModelFactory: SplashViewModelFactory

    private lateinit var binding: FragmentSplashBinding
    private lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectSplashFragment(
            splashFragment = this
        )
        splashViewModel = ViewModelProvider(
            owner = this,
            factory = splashViewModelFactory
        )[SplashViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addAnim()
        lifecycleScope.launch {
            setRoles()
            setServices()
            setProducts()
            splashViewModel.apply {
                if (getUserId() == 0L) {
                    delay(1000)
                    Navigation.findNavController(view)
                        .navigate(R.id.action_splashFragment_to_signInFragment)
                } else {
                    delay(3000)
                    Navigation.findNavController(view)
                        .navigate(R.id.action_splashFragment_to_rootFragment)
                }
            }
        }
    }

    private fun setRoles() {
        val roles = listOf(Role(1, "USER"), Role(2, "STAFF"))
        for (role in roles)
            splashViewModel.upsertRole(role)
    }

    private fun setServices() {
        val services = listOf(
            Service(1, "Удаление вмятин без покраски", "Удаление вмятин современным оборудованием без покраски.", 2000f),
            Service(2, "Диагностика подвески", "Диагностика подвески автомобиля предназначена для определения характеристик фактической работы подвески и выявления неисправностей тех или иных узлов и деталей.", 300f),
            Service(3, "Диагностика тормозной системы", "Процесс проверки и анализа работы всех компонентов тормозной системы автомобиля.", 1500f),
        )
        for (service in services)
            splashViewModel.upsertService(service)
    }

    private fun setProducts() {
        val products = listOf(
            Product(1, "Ремкомплект", "Только использование оригинальных запасных частей ГАЗ может гарантировать штатную работу систем, в которую входят данные детали.", 1089f),
            Product(2, "Диск автомобильный", "Диск автомобильный ВАЗ, R13, штампованный. Только использование оригинальных запасных частей ГАЗ может гарантировать штатную работу систем, в которую входят данные детали.", 1400f),
            Product(3, "Подушка-Отбойник", "Внимание ! Цена указывается за 1 единицу товара! Вы Смотрите : Номер товара : 522913428 Производитель : GAZ", 190f),
        )
        for (product in products)
            splashViewModel.upsertProduct(product)
    }

    private fun addAnim() {
        val rotate = AnimationUtils.loadAnimation(context, R.anim.loading_rotate)
        binding.imgLoading.animation = rotate
    }
}