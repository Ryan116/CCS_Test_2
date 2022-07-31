package com.example.ccs_test_2.features.mainScreen.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ccs_test_2.common.constants.Constants
import com.example.ccs_test_2.common.constants.Constants.DEFAULT_VALUE_CURRENCY_RATE_NAME
import com.example.ccs_test_2.features.mainScreen.domain.model.MainCurrencyRateItem
import com.example.ccs_test_2.features.mainScreen.domain.usecase.AddBookmarkUseCase
import com.example.ccs_test_2.features.mainScreen.domain.usecase.DeleteBookmarkUseCase
import com.example.ccs_test_2.features.mainScreen.domain.usecase.GetCurrencyRateUseCase
import com.example.ccs_test_2.features.mainScreen.presentation.CurrencyApiStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCurrencyRateUseCase: GetCurrencyRateUseCase,
    private val addBookmarkUseCase: AddBookmarkUseCase,
    private val deleteBookmarkUseCase: DeleteBookmarkUseCase,
) : ViewModel() {

    private var _status = MutableStateFlow<CurrencyApiStatus>(CurrencyApiStatus.Empty)
    val status: StateFlow<CurrencyApiStatus> = _status

    private var _currencyRates = MutableStateFlow<List<MainCurrencyRateItem>>(mutableListOf())
    val currencyRates: StateFlow<List<MainCurrencyRateItem>> = _currencyRates

    private var _currentCurrencyCode = MutableStateFlow<String>(DEFAULT_VALUE_CURRENCY_RATE_NAME)
    val currentCurrencyCode: StateFlow<String> = _currentCurrencyCode


    init {
        getCurrencyList()
    }

    fun setCurrency(value: String) {
        _currentCurrencyCode.value = value
    }

    fun filterCurrencyList(filterType: String) {
        _currencyRates.value = when (filterType) {
            Constants.CURRENCY_FILTER_TYPE_ASC -> {
                _currencyRates.value.sortedBy { it.date }
            }
            Constants.CURRENCY_FILTER_TYPE_DESC -> {
                _currencyRates.value.sortedByDescending { it.date }
            }
            else -> {
                _currencyRates.value.sortedBy { it.date }
            }
        }
    }


    fun getCurrencyList(
        dateFrom: String = Constants.DEFAULT_VALUE_DATE_RANGE_1,
        dateBefore: String = Constants.DEFAULT_VALUE_DATE_RANGE_2,
        currencyCode: String = Constants.DEFAULT_VALUE_CURRENCY_CODE
    ) {
        viewModelScope.launch {
            _status.value = CurrencyApiStatus.LOADING
            try {
                _currencyRates.value =
                    getCurrencyRateUseCase.getCurrencyRate(dateFrom, dateBefore, currencyCode)
                _status.value = CurrencyApiStatus.DONE
            } catch (e: Exception) {
                _status.value = CurrencyApiStatus.ERROR(e.toString())
            }
        }
    }

    fun addBookmark(mainCurrencyRateItem: MainCurrencyRateItem) {
        viewModelScope.launch(Dispatchers.IO) {
            addBookmarkUseCase.addBookmark(mainCurrencyRateItem)
        }
    }

    fun deleteBookmark(mainCurrencyRateItem: MainCurrencyRateItem) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteBookmarkUseCase.deleteBookmark(mainCurrencyRateItem)
        }
    }
}