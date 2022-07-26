package com.example.ccs_test_2.features.valuteListScreen.presentation.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.ccs_test_2.R
import com.example.ccs_test_2.databinding.RecordItemBinding
import com.example.ccs_test_2.features.valuteListScreen.domain.model.RecordDomain

class ValuteAdapter(private val bookmarkClickListener: BookmarkClickListener) :
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
        var pressed = true
        holder.bookmark.setOnClickListener {
            if (pressed) {
                pressed = false
                holder.bookmark.setImageResource(R.drawable.ic_add_to_favorite_full_2)
                bookmarkClickListener.addBookmark(record)
            } else {
                pressed = true
                holder.bookmark.setImageResource(R.drawable.ic_add_to_favorite_empty_2)
                bookmarkClickListener.deleteBookmark(record)
            }
        }
    }

    interface BookmarkClickListener {
        fun addBookmark(recordDomain: RecordDomain)
        fun deleteBookmark(recordDomain: RecordDomain)
    }
}



