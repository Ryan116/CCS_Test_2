package com.example.ccs_test_2.features.valuteListScreen.presentation.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.ccs_test_2.databinding.RecordItemBinding
import com.example.ccs_test_2.features.valuteListScreen.domain.model.RecordDomain

class ValuteAdapter() :
    ListAdapter<RecordDomain, ValuteViewHolder>(ValuteDiffCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ValuteViewHolder {
        return ValuteViewHolder(
            RecordItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ValuteViewHolder, position: Int) {
        val record = getItem(position)
        holder.bind(record)
    }
}



