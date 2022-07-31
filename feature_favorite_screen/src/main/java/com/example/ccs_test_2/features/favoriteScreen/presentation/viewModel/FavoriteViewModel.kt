package com.example.ccs_test_2.features.valuteFavoriteScreen.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.model.FavoriteCurrencyRateItem
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.usecase.DeleteAllBookmarksUseCase
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.usecase.DeleteBookmarkUseCase
import com.example.ccs_test_2.features.valuteFavoriteScreen.domain.usecase.GetBookmarksListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getBookmarksListUseCase: GetBookmarksListUseCase,
    private val deleteBookmarkUseCase: DeleteBookmarkUseCase,
    private val deleteAllBookmarksUseCase: DeleteAllBookmarksUseCase
) : ViewModel() {

    private var _listFavoriteCurrencyRate = MutableStateFlow<List<FavoriteCurrencyRateItem>>(
        mutableListOf()
    )
    val listFavoriteCurrencyRate: StateFlow<List<FavoriteCurrencyRateItem>> =
        _listFavoriteCurrencyRate

    init {
        getBookmarksList()
    }

    private fun getBookmarksList() {
        viewModelScope.launch {
            getBookmarksListUseCase.getBookmarksList()
                .onEach { _listFavoriteCurrencyRate.value = it }
                .launchIn(viewModelScope + Dispatchers.IO)
        }
    }

    fun deleteBookmark(favoriteCurrencyRateItem: FavoriteCurrencyRateItem) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteBookmarkUseCase.deleteBookmark(favoriteCurrencyRateItem)
        }
    }

    fun deleteAllBookmarks() {
        viewModelScope.launch(Dispatchers.IO) {
            deleteAllBookmarksUseCase.deleteAllBookmarks()
        }
    }
}

