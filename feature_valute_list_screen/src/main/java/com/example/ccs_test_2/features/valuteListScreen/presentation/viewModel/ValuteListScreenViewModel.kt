package com.example.ccs_test_2.features.valuteListScreen.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ccs_test_2.features.valuteListScreen.domain.model.RecordDomain
import com.example.ccs_test_2.features.valuteListScreen.domain.usecase.AddBookmarkUseCase
import com.example.ccs_test_2.features.valuteListScreen.domain.usecase.DeleteBookmarkUseCase
import com.example.ccs_test_2.features.valuteListScreen.domain.usecase.GetCurrencyRateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

sealed class ValuteApiStatus() {
    class LOADING() : ValuteApiStatus()
    class ERROR(val error: String) : ValuteApiStatus()
    class DONE() : ValuteApiStatus()
    object Empty : ValuteApiStatus()
}

@HiltViewModel
class ValuteListScreenViewModel @Inject constructor(
    private val getCurrencyRateUseCase: GetCurrencyRateUseCase,
    private val addBookmarkUseCase: AddBookmarkUseCase,
    private val deleteBookmarkUseCase: DeleteBookmarkUseCase,
) : ViewModel() {

    private var _status = MutableStateFlow<ValuteApiStatus>(ValuteApiStatus.Empty)
    val status: StateFlow<ValuteApiStatus> = _status

    private var _valuteCurses = MutableStateFlow<List<RecordDomain>>(mutableListOf())
    val valuteCurses: StateFlow<List<RecordDomain>> = _valuteCurses

    private var _listDatesFromBefore = mutableListOf<String>()
    val listDatesFromBefore: List<String> = _listDatesFromBefore

    private var _currentCurrency = MutableStateFlow<String>("USD")
    val currentCurrency: StateFlow<String> = _currentCurrency


    init {
        getLastMonthDates()
        getValuteList(listDatesFromBefore[0], listDatesFromBefore[1])
    }

    fun setCurrency(value: String) {
        _currentCurrency.value = value
    }

    fun filterCurrencyList(filterType: String) {
        _valuteCurses.value = when(filterType) {
            "1..10" -> {
                        _valuteCurses.value.sortedBy { it.value }
                    }
            "10..1" -> {
                        _valuteCurses.value.sortedByDescending { it.value }
                    }
            else -> {
                        _valuteCurses.value.sortedBy { it.date }
                    }
        }
    }


    fun getValuteList(dateFrom: String = "01/07/2022", dateBefore: String = "26/07/2022", valuteCode: String = "R01235") {
        viewModelScope.launch {
            _status.value = ValuteApiStatus.LOADING()
            try {
                _valuteCurses.value =
                    getCurrencyRateUseCase.getValuteCurs(dateFrom, dateBefore, valuteCode)
                _status.value = ValuteApiStatus.DONE()
            } catch (e: Exception) {
                _status.value = ValuteApiStatus.ERROR(e.toString())
                Log.d("Valute", e.toString())
            }
        }
    }

    private fun getLastMonthDates() {
        val calendar = Calendar.getInstance()
        val dayToday = calendar.get(Calendar.DAY_OF_MONTH)
        val monthToday = (calendar.get(Calendar.MONTH)) + 1
        val yearToday = calendar.get(Calendar.YEAR)
        val dayTodayRef = String.format("%02d", dayToday)
        val monthTodayRef = String.format("%02d", (monthToday))
        val dateNow = "$dayTodayRef/$monthTodayRef/$yearToday"
        var dayMonthAgo = dayToday
        if (dayToday > 28) {
            dayMonthAgo = 28
        }
        var dayMonthAgoRef = String.format("%02d", dayMonthAgo)
        var yearMontAgo = yearToday
        var monthMonthAgoRef = ""
        var monthMonthAgo = monthToday
        if (monthToday > 1) {
            monthMonthAgoRef = String.format("%02d", (monthMonthAgo - 1))
        } else {
            yearMontAgo = yearToday - 1
            monthMonthAgoRef = String.format("%02d", (12))
        }
        val dateMonthAgo = "$dayMonthAgoRef/$monthMonthAgoRef/$yearMontAgo"
        _listDatesFromBefore.apply {
            add(dateMonthAgo)
            add(dateNow)
        }
    }

    fun addBookmark(recordDomain: RecordDomain) {
        viewModelScope.launch(Dispatchers.IO) {
            addBookmarkUseCase.addBookmark(recordDomain)
        }
    }

    fun deleteBookmark(recordDomain: RecordDomain) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteBookmarkUseCase.deleteBookmark(recordDomain)
        }
    }

}