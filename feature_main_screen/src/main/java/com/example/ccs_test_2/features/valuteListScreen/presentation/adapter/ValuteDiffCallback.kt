package com.example.ccs_test_2.features.valuteListScreen.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.ccs_test_2.features.valuteListScreen.domain.model.RecordDomain

class ValuteDiffCallback:DiffUtil.ItemCallback<RecordDomain>() {
    override fun areItemsTheSame(oldItem: RecordDomain, newItem: RecordDomain): Boolean {
        return oldItem.date == newItem.date
    }

    override fun areContentsTheSame(oldItem: RecordDomain, newItem: RecordDomain): Boolean {
        return oldItem == newItem
    }
}