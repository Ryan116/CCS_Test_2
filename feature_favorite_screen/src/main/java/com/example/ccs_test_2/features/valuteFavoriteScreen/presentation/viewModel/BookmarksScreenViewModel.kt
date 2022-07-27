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
import kotlinx.coroutines.launch

class BookmarksScreenViewModel(
    private val getBookmarksListUseCase: GetBookmarksListUseCase,
    private val deleteBookmarkUseCase: DeleteBookmarkUseCase,
    private val deleteAllBookmarksUseCase: DeleteAllBookmarksUseCase
) : ViewModel() {

    var bookmarksList: LiveData<List<RecordBookmark>> = MutableLiveData()

    init {
        getBookmarksList()
    }

    private fun getBookmarksList() {
        viewModelScope.launch {
            bookmarksList = getBookmarksListUseCase.getBookmarksList()
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

