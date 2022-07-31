package com.example.ccs_test_2.features.mainScreen.presentation.viewModel

sealed class CurrencyApiStatus() {
    object LOADING : CurrencyApiStatus()
    class ERROR(val error: String) : CurrencyApiStatus()
    object DONE : CurrencyApiStatus()
    object Empty : CurrencyApiStatus()
}
