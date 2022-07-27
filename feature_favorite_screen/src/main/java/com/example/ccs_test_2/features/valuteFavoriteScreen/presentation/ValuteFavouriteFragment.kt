package com.example.ccs_test_2.features.valuteFavoriteScreen.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ccs_test_2.features.valuteFavoriteScreen.databinding.FragmentValuteFavouriteBinding
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.model.RecordBookmark
import com.example.ccs_test_2.features.valuteFavoriteScreen.presentation.adapter.BookmarkAdapter
import com.example.ccs_test_2.features.valuteFavoriteScreen.presentation.viewModel.BookmarksScreenViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class ValuteFavouriteFragment : Fragment() {

    private var _binding: FragmentValuteFavouriteBinding? = null
    private val binding
        get() = _binding!!

    private val bookmarksScreenViewModel by viewModel<BookmarksScreenViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentValuteFavouriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bookmarksScreenViewModel.bookmarksList.observe(viewLifecycleOwner) {
            val adapterBookmark = BookmarkAdapter(
                object : BookmarkAdapter.BookmarkClickListener {

                    override fun deleteBookmark(recordBookmark: RecordBookmark) {
                        bookmarksScreenViewModel.deleteBookmark(recordBookmark)
                    }

                }
            )
            Log.d("Valute", it.toString())
            adapterBookmark.submitList(it)
            binding.recyclerViewValuteList.adapter = adapterBookmark
            binding.recyclerViewValuteList.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        }

        binding.floatingActionButton.setOnClickListener {
            bookmarksScreenViewModel.deleteAllBooks()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}