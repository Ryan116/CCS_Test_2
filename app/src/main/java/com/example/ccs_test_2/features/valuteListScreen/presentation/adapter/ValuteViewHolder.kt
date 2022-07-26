package com.example.ccs_test_2.features.valuteListScreen.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.ccs_test_2.databinding.RecordItemBinding
import com.example.ccs_test_2.features.valuteListScreen.domain.model.RecordDomain

class ValuteViewHolder(private var binding: RecordItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(record: RecordDomain) {
        binding.apply {
            textViewDate.text = record.date
            textViewNominal.text = record.nominal.toString()
            textViewValue.text = record.value
        }
    }

}



