package com.example.currencyconverterapp.di;

import com.example.currencyconverterapp.ui.activity.CalculatorActivity
import com.example.currencyconverterapp.ui.activity.HomeActivity
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        ApplicationModule::class,
        RepositoriesModule::class,
        ViewModelModule::class,
    ]
)
@Singleton
interface ApplicationComponent {
    fun inject(target: HomeActivity)
    fun inject(target: CalculatorActivity)
}