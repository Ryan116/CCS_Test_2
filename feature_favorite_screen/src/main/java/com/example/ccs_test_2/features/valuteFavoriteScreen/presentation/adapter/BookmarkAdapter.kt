package com.example.ccs_test_2.features.valuteFavoriteScreen.presentation.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.ccs_test_2.features.valuteFavoriteScreen.databinding.RecordBookmarkItemBinding
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.model.RecordBookmark

class BookmarkAdapter(
    private val bookmarkClickListener: BookmarkClickListener
) :
    ListAdapter<RecordBookmark, BookmarkViewHolder>(BookmarkDiffCallback()) {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookmarkViewHolder {
        return BookmarkViewHolder(RecordBookmarkItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
        val bookmark = getItem(position)
        holder.bind(bookmark)
        holder.bookmark.setOnClickListener {
            bookmarkClickListener.deleteBookmark(bookmark)
        }


    }

    interface BookmarkClickListener {
        fun deleteBookmark(recordBookmark: RecordBookmark)
    }
}



