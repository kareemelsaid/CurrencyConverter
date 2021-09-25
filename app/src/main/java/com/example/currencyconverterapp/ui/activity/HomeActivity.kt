package com.example.currencyconverterapp.ui.activity

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.currencyconverterapp.R
import com.example.currencyconverterapp.base.BaseActivity
import com.example.currencyconverterapp.models.response.RateView
import com.example.currencyconverterapp.ui.viewmodel.HomeViewModel
import com.example.currencyconverterapp.utilities.ViewState
import com.example.currencyconverterapp.utilities.builders.recyclerview.RecyclerViewBuilder
import com.example.currencyconverterapp.utilities.builders.recyclerview.RecyclerViewBuilderFactory
import com.example.currencyconverterapp.utilities.extensions.arraylist.toArrayList
import com.example.currencyconverterapp.utilities.extensions.toast.toast
import kotlinx.android.synthetic.main.activity_home.*

enum class CurrencyKey(val key:String){
    COUNTRY("COUNTRY"),RATE("RATE")
}

class HomeActivity : BaseActivity() {
    private lateinit var recyclerViewBuilder: RecyclerViewBuilder
    private lateinit var viewModel: HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this)
        setContentView(R.layout.activity_home)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[HomeViewModel::class.java]
        setOnClickListener()
        setupObservers()
        viewModel.getRates()
    }

    private fun setOnClickListener() {
        recyclerViewBuilder =
            RecyclerViewBuilderFactory(ratesRecyclerView)
                .buildWithLinearLayout(
                    isDataBindingEnabled = true,
                    orientation = LinearLayoutManager.VERTICAL,
                )
                .setOnItemClick { itemView, model, position ->
                    val intent = Intent(this,CalculatorActivity::class.java)
                    intent.putExtra(CurrencyKey.COUNTRY.key,(model as RateView).country)
                    intent.putExtra(CurrencyKey.RATE.key, model.rate)
                    startActivity(intent)
                }

    }

    private fun setupObservers() {
        viewModel.rateViews.observe(this, {
            when (it) {
                is ViewState.Loading -> {
                    loadingDialog.show()

                }
                is ViewState.Success -> {
                    loadingDialog.dismiss()
                    recyclerViewBuilder.setViewItems(it.data.map {
                        it.viewItem
                    }.toArrayList())
                }
                is ViewState.Error -> {
                    toast(it.message.errorMessage)
                }
            }
        })
    }
}