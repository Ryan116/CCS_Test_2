package com.example.ccs_test_2.features.valuteFavoriteScreen.presentation.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.ccs_test_2.features.valuteFavoriteScreen.R
import com.example.ccs_test_2.features.valuteFavoriteScreen.databinding.RecordItemBinding
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.model.RecordBookmark

class BookmarkAdapter(
    private val bookmarkClickListener: BookmarkClickListener
) :
    ListAdapter<RecordBookmark, BookmarkViewHolder>(BookmarkDiffCallback()) {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookmarkViewHolder {
        return BookmarkViewHolder(RecordItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
        val bookmark = getItem(position)
        holder.bind(bookmark)
        var pressed = true
        holder.bookmark.setOnClickListener {
            if (pressed) {
                pressed = false
                holder.bookmark.setImageResource(R.drawable.ic_add_to_favorite_full_2)
                bookmarkClickListener.deleteBookmark(bookmark)
            } else {
                pressed = true
                holder.bookmark.setImageResource(R.drawable.ic_add_to_favorite_empty_2)
            }
        }



    }

    interface BookmarkClickListener {
        fun deleteBookmark(recordBookmark: RecordBookmark)
    }
}



