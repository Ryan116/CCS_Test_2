package com.example.ccs_test_2.features.valuteFavoriteScreen.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.model.RecordBookmark
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.usecase.DeleteAllBookmarksUseCase
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.usecase.DeleteBookmarkUseCase
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.usecase.GetBookmarksListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.core.KoinApplication.Companion.init


class BookmarksScreenViewModel(
    private val getBookmarksListUseCase: GetBookmarksListUseCase,
    private val deleteBookmarkUseCase: DeleteBookmarkUseCase,
    private val deleteAllBookmarksUseCase: DeleteAllBookmarksUseCase
) : ViewModel() {

    private var _bookmarksList = MutableStateFlow<List<RecordBookmark>>(mutableListOf())
    val bookmarksList: StateFlow<List<RecordBookmark>> = _bookmarksList


    lateinit var flow1: Flow<List<RecordBookmark>>


    init {
        getBookmarksList()
    }

    private fun getBookmarksList() {
        viewModelScope.launch {
            flow1 = getBookmarksListUseCase.getBookmarksList()
        }
    }




    fun deleteBookmark(recordBookmark: RecordBookmark) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteBookmarkUseCase.deleteBookmark(recordBookmark)
        }
    }

    fun deleteAllBooks() {
        viewModelScope.launch(Dispatchers.IO) {
            deleteAllBookmarksUseCase.deleteAllBookmarks()
        }
    }


}

