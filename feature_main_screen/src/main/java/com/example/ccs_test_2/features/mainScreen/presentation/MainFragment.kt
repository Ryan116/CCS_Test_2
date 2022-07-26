package com.example.ccs_test_2.features.mainScreen.presentation

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ccs_test_2.common.constants.Constants
import com.example.ccs_test_2.common.constants.CurrencyCodeConstants
import com.example.ccs_test_2.features.mainScreen.R
import com.example.ccs_test_2.features.mainScreen.databinding.FragmentMainBinding
import com.example.ccs_test_2.features.mainScreen.domain.model.MainCurrencyRateItem
import com.example.ccs_test_2.features.mainScreen.presentation.adapter.BookmarkClickListener
import com.example.ccs_test_2.features.mainScreen.presentation.adapter.MainAdapter
import com.example.ccs_test_2.features.mainScreen.presentation.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding
        get() = _binding!!

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        setUserDatesOnTextViews(binding.textViewDateFrom)
        setUserDatesOnTextViews(binding.textViewDateBefore)
        changeCurrencyType()
        chooseCurrencyListFilter()
        updateCurrencyList()
        setupState()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupAdapter() {
        val mainAdapter = MainAdapter(
            object : BookmarkClickListener {
                override fun addBookmark(mainCurrencyRateItemDomain: MainCurrencyRateItem) {
                    mainViewModel.addBookmark(mainCurrencyRateItemDomain)
                }

                override fun deleteBookmark(mainCurrencyRateItemDomain: MainCurrencyRateItem) {
                    mainViewModel.deleteBookmark(mainCurrencyRateItemDomain)
                }
            }
        )
        binding.recyclerViewCurrencyList.apply {
            adapter = mainAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
        lifecycleScope.launch() {
            mainViewModel.currencyRates.collect {
                mainAdapter.submitList(it)
            }
        }
    }

    private fun setUserDatesOnTextViews(textView: TextView) {
        textView.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val dateDialog = DatePickerDialog(
                requireContext(),
                DatePickerDialog.OnDateSetListener { _, userYear, userMonth, userDAy ->
                    val userDayRef = String.format("%02d", userDAy)
                    val userMonRef = String.format("%02d", (userMonth + 1))
                    val textDate = "$userDayRef/$userMonRef/$userYear"
                    textView.text = textDate
                },
                year,
                month,
                day
            ).show()
        }
    }

    private fun updateCurrencyList() {
        binding.buttonUpdate.setOnClickListener {
            val dateFrom = binding.textViewDateFrom.text.toString()
            val dateBefore = binding.textViewDateBefore.text.toString()
            val dateFromList = dateFrom.split("/")
            val dateBeforeList = dateBefore.split("/")
            verifyDates(dateBeforeList, dateFromList, dateFrom, dateBefore)
        }
    }

    private fun verifyDates(
        dateBeforeList: List<String>,
        dateFromList: List<String>,
        dateFrom: String,
        dateBefore: String
    ) {
        if ((dateBeforeList[2] > dateFromList[2])
            || (dateBeforeList[2] == dateFromList[2] && dateBeforeList[1] > dateFromList[1])
            || (dateBeforeList[2] == dateFromList[2] && dateBeforeList[1] == dateFromList[1]
                    && dateBeforeList[0] >= dateFromList[0])
        ) {
            mainViewModel.getCurrencyList(
                dateFrom = dateFrom,
                dateBefore = dateBefore,
                currencyCode = CurrencyCodeConstants.USD.code
            )
        } else {
            Toast.makeText(
                requireContext(),
                getString(R.string.toast_incorrect_date),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun chooseCurrencyListFilter() {
        binding.spinnerFilter.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val filterType = parent?.getItemAtPosition(position).toString()
                when (filterType) {
                    Constants.CURRENCY_FILTER_TYPE_ASC -> {
                        mainViewModel.filterCurrencyList(filterType)
                    }
                    Constants.CURRENCY_FILTER_TYPE_DESC -> {
                        mainViewModel.filterCurrencyList(filterType)
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun changeCurrencyType() {
        binding.spinnerSelectCurrency.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val currencyName = parent?.getItemAtPosition(position).toString()
                    when (currencyName) {
                        CurrencyCodeConstants.USD.name -> {
                            mainViewModel.setCurrency(CurrencyCodeConstants.USD.code)
                        }
                        CurrencyCodeConstants.AUD.name -> {
                            mainViewModel.setCurrency(CurrencyCodeConstants.AUD.code)
                        }
                        CurrencyCodeConstants.AZN.name -> {
                            mainViewModel.setCurrency(CurrencyCodeConstants.AZN.code)
                        }
                        CurrencyCodeConstants.GBP.name -> {
                            mainViewModel.setCurrency(CurrencyCodeConstants.GBP.code)
                        }
                        CurrencyCodeConstants.AMD.name -> {
                            mainViewModel.setCurrency(CurrencyCodeConstants.AMD.code)
                        }
                        CurrencyCodeConstants.BYN.name -> {
                            mainViewModel.setCurrency(CurrencyCodeConstants.BYN.code)
                        }
                        CurrencyCodeConstants.BGN.name -> {
                            mainViewModel.setCurrency(CurrencyCodeConstants.BGN.code)
                        }
                        CurrencyCodeConstants.BRL.name -> {
                            mainViewModel.setCurrency(CurrencyCodeConstants.BRL.code)
                        }
                        CurrencyCodeConstants.HUF.name -> {
                            mainViewModel.setCurrency(CurrencyCodeConstants.HUF.code)
                        }
                        CurrencyCodeConstants.HKD.name -> {
                            mainViewModel.setCurrency(CurrencyCodeConstants.HKD.code)
                        }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
        lifecycleScope.launch() {
            mainViewModel.currentCurrencyCode.collect {
                mainViewModel.getCurrencyList(
                    dateFrom = binding.textViewDateFrom.text.toString(),
                    dateBefore = binding.textViewDateBefore.text.toString(),
                    currencyCode = it
                )
            }
        }
    }

    private fun setupState() {
        lifecycleScope.launch(Dispatchers.Main) {
            mainViewModel.status.collect {
                when (it) {
                    is CurrencyApiStatus.ERROR -> {
                        binding.progressBar.isVisible = false
                        Toast.makeText(
                            requireContext(),
                            it.error,
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                    CurrencyApiStatus.DONE -> {
                        binding.progressBar.isVisible = false

                    }
                    CurrencyApiStatus.LOADING -> {
                        binding.progressBar.isVisible = true
                    }
                    else -> {
                        Unit
                    }
                }
            }
        }
    }
}