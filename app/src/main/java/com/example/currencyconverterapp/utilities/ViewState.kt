package com.example.currencyconverterapp.utilities
import com.example.currencyconverterapp.models.response.Message


sealed class ViewState<out T> {
    object Loading : ViewState<Nothing>()
    class Success<T>(var data: T): ViewState<T>()
    class Error(val message: Message): ViewState<Nothing>()
}

sealed class CompletableViewState {
    object Loading : CompletableViewState()
    object Completed : CompletableViewState()
    class Error(val message: Message): CompletableViewState()
}
