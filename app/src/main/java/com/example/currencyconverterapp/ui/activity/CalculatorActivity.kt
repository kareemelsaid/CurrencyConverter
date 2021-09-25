package com.example.currencyconverterapp.ui.activity

import android.os.Bundle
import com.example.currencyconverterapp.R
import com.example.currencyconverterapp.base.BaseActivity
import com.example.currencyconverterapp.utilities.extensions.toast.toast
import kotlinx.android.synthetic.main.activity_calculator.*

class CalculatorActivity : BaseActivity() {
    private var rate: Double? = 0.0
    private var country: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        country = intent.extras?.getString(CurrencyKey.COUNTRY.key)
        rate = intent.extras?.getDouble(CurrencyKey.RATE.key)
        setData()
        setOnClickListener()
    }

    private fun setData(){
        anotherCurrencyValueTextView.text = rate.toString()
        anotherCurrencyTextView.text = country
    }

    private fun calculate(): Double {
        return baseCurrencyEditText.text.toString().toDouble() * rate!!
    }

    private fun setOnClickListener(){
        calculatorButton.setOnClickListener {
            if (baseCurrencyEditText.text.toString().toDouble() != 0.0){
                anotherCurrencyValueTextView.text = calculate().toString()
            }else{
                toast(R.string.zero_money)
            }
        }
    }
}