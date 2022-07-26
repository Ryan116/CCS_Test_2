package com.example.ccs_test_2.features.valuteListScreen.presentation.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ccs_test_2.features.valuteListScreen.domain.model.RecordDomain
import com.example.ccs_test_2.features.valuteListScreen.domain.usecase.AddBookmarkUseCase
import com.example.ccs_test_2.features.valuteListScreen.domain.usecase.DeleteBookmarkUseCase
import com.example.ccs_test_2.features.valuteListScreen.domain.usecase.GetValuteCursUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*



enum class ValuteApiStatus { LOADING, ERROR, DONE }

class ValuteListScreenViewModel(
    private val getValuteCursUseCase: GetValuteCursUseCase,
    private val addBookmarkUseCase: AddBookmarkUseCase,
    private val deleteBookmarkUseCase: DeleteBookmarkUseCase,
) : ViewModel() {

    private val _status = MutableLiveData<ValuteApiStatus>()
    val status: LiveData<ValuteApiStatus> = _status

    private val _valuteCurses = MutableLiveData<List<RecordDomain>>()
    val valuteCurses: LiveData<List<RecordDomain>> = _valuteCurses

    private val _listDatesFromBefore = mutableListOf<String>()
    val listDatesFromBefore: List<String> = _listDatesFromBefore

    private val _currentCurrency = MutableLiveData<String>()
    val currentCurrency: LiveData<String> = _currentCurrency


    init {
        _currentCurrency.value = "USD"
        getLastMonthDates()
        getValuteList(listDatesFromBefore[0], listDatesFromBefore[1])
    }

    fun setCurrency(value: String) {
        _currentCurrency.value = value
    }

    fun filterCurrencyList(filterType: String) {
        _valuteCurses.value = when(filterType) {
            "1..10" -> {_valuteCurses.value?.sortedBy { it.value }}
            "10..1" -> {_valuteCurses.value?.sortedByDescending { it.value }}
            else -> {_valuteCurses.value?.sortedBy { it.date }}
        }
    }


    fun getValuteList(dateFrom: String = "01/07/2022", dateBefore: String = "26/07/2022", valuteCode: String = "R01235") {
        viewModelScope.launch {
            _status.value = ValuteApiStatus.LOADING
            try {
                _valuteCurses.value =
                    getValuteCursUseCase.getValuteCurs(dateFrom, dateBefore, valuteCode)
                _status.value = ValuteApiStatus.DONE
            } catch (e: Exception) {
                _status.value = ValuteApiStatus.ERROR
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