package com.example.ccs_test_2.features.valuteListScreen.presentation

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ccs_test_2.R
import com.example.ccs_test_2.databinding.FragmentValuteListBinding
import com.example.ccs_test_2.features.valuteListScreen.presentation.adapter.ValuteAdapter
import com.example.ccs_test_2.features.valuteListScreen.presentation.viewModel.ValuteListScreenViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*

class ValuteListFragment : Fragment() {

    private lateinit var binding: FragmentValuteListBinding

    private val valuteListScreenViewModel by viewModel<ValuteListScreenViewModel>()

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

        valuteListScreenViewModel.valuteCurses.observe(viewLifecycleOwner) {
            val valuteAdapter = ValuteAdapter()
            valuteAdapter.submitList(it)
            binding.apply {
                recyclerViewValuteList.adapter = valuteAdapter
                recyclerViewValuteList.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            }
        }

        setDateOnTextView(binding.textViewDateFrom)
        setDateOnTextView(binding.textViewDateBefore)

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
                valuteListScreenViewModel.getValuteList(dateFrom, dateBefore)
            } else {
                Toast.makeText(
                    requireContext(),
                    "'Select date from' must be less than 'Select date before!' Choose another date!",
                    Toast.LENGTH_SHORT
                ).show()
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