package com.example.ccs_test_2.features.valuteListScreen.presentation

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ccs_test_2.features.valuteListScreen.databinding.FragmentValuteListBinding
import com.example.ccs_test_2.features.valuteListScreen.domain.model.RecordDomain
import com.example.ccs_test_2.features.valuteListScreen.presentation.adapter.ValuteAdapter
import com.example.ccs_test_2.features.valuteListScreen.presentation.viewModel.ValuteApiStatus
import com.example.ccs_test_2.features.valuteListScreen.presentation.viewModel.ValuteListScreenViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class ValuteListFragment : Fragment() {

    private lateinit var binding: FragmentValuteListBinding

    private val valuteListScreenViewModel: ValuteListScreenViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentValuteListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            textViewDateFrom.text = valuteListScreenViewModel.listDatesFromBefore[0]
            textViewDateBefore.text = valuteListScreenViewModel.listDatesFromBefore[1]
        }

        lifecycleScope.launch(Dispatchers.Main) {
            valuteListScreenViewModel.valuteCurses.collect {
                val valuteAdapter = ValuteAdapter(
                    object : ValuteAdapter.BookmarkClickListener {
                        override fun addBookmark(recordDomain: RecordDomain) {
                            valuteListScreenViewModel.addBookmark(recordDomain)
                        }

                        override fun deleteBookmark(recordDomain: RecordDomain) {
                            valuteListScreenViewModel.deleteBookmark(recordDomain)
                        }

                    }
                )
                valuteAdapter.submitList(it)
                binding.apply {
                    recyclerViewValuteList.adapter = valuteAdapter
                    recyclerViewValuteList.layoutManager =
                        LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                }
            }
        }


        setDateOnTextView(binding.textViewDateFrom)
        setDateOnTextView(binding.textViewDateBefore)

        binding.spinnerSelectValute.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val currencyName = parent?.getItemAtPosition(position).toString()
                when (currencyName) {
                    "USD" -> {valuteListScreenViewModel.setCurrency("R01235")}
                    "AUD" -> {valuteListScreenViewModel.setCurrency("R01010")}
                    "AZN" -> {valuteListScreenViewModel.setCurrency("R01020A")}
                    "GBP" -> {valuteListScreenViewModel.setCurrency("R01035")}
                    "AMD" -> {valuteListScreenViewModel.setCurrency("R01060")}
                    "BYN" -> {valuteListScreenViewModel.setCurrency("R01090B")}
                    "BGN" -> {valuteListScreenViewModel.setCurrency("R01100")}
                    "BRL" -> {valuteListScreenViewModel.setCurrency("R01115")}
                    "HUF" -> {valuteListScreenViewModel.setCurrency("R01135")}
                    "HKD" -> {valuteListScreenViewModel.setCurrency("R01200")}
                    else -> {valuteListScreenViewModel.setCurrency("R01235")}
                }
                lifecycleScope.launch(Dispatchers.Main) {
                    valuteListScreenViewModel.currentCurrency.collect {
                        valuteListScreenViewModel.getValuteList(valuteCode = it)
                    }
                }


            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        binding.spinnerFilter.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val filterType = parent?.getItemAtPosition(position).toString()
                when (filterType) {
                    "1..10" -> {valuteListScreenViewModel.filterCurrencyList(filterType)}
                    "10..1" -> {valuteListScreenViewModel.filterCurrencyList(filterType)}
                    else -> {valuteListScreenViewModel.filterCurrencyList(filterType)}
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        binding.buttonUpdate.setOnClickListener {
            val dateFrom = binding.textViewDateFrom.text.toString()
            val dateBefore = binding.textViewDateBefore.text.toString()
            val dateFromList = dateFrom.split("/")
            val dateBeforeList = dateBefore.split("/")
            if ((dateBeforeList[2] > dateFromList[2])
                || (dateBeforeList[2] == dateFromList[2] && dateBeforeList[1] > dateFromList[1])
                || (dateBeforeList[2] == dateFromList[2] && dateBeforeList[1] == dateFromList[1]
                        && dateBeforeList[0] >= dateFromList[0])
            ) {
                lifecycleScope.launch() {
                    valuteListScreenViewModel.currentCurrency.collect {
                        valuteListScreenViewModel.getValuteList(dateFrom = dateFrom, dateBefore = dateBefore, valuteCode = it)
                    }
                }


            } else {
                Toast.makeText(
                    requireContext(),
                    "'Select date from' must be less than 'Select date before!' Choose another date!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        lifecycleScope.launch (Dispatchers.Main) {
            valuteListScreenViewModel.status.collect {
                when (it) {
                    is ValuteApiStatus.ERROR -> {
                        Toast.makeText(
                            requireContext(),
                            it.error,
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                    else -> {

                    }
                }
            }
        }


    }


    private fun setDateOnTextView(textView: TextView) {
        textView.setOnClickListener {
            val calendar = Calendar.getInstance()
            SimpleDateFormat("E MMM d", Locale.getDefault())
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val dateDialog = DatePickerDialog(
                requireContext(),
                DatePickerDialog.OnDateSetListener { view, mYear, mMon, mDay ->
                    val mDayRef = String.format("%02d", mDay)
                    val mMonRef = String.format("%02d", (mMon + 1))
                    val textDate = "$mDayRef/$mMonRef/$mYear"
                    textView.text = textDate
                },
                year,
                month,
                day
            ).show()
        }
    }
}