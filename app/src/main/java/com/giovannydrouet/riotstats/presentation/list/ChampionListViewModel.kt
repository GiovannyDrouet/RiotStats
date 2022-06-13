package com.giovannydrouet.riotstats.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.giovannydrouet.riotstats.domain.GetChampions
import kotlinx.coroutines.launch
import javax.inject.Inject

class ChampionListViewModel @Inject constructor(
    private val getChampions: GetChampions
) : ViewModel() {

    fun getChampionList() {
        viewModelScope.launch {
            getChampions.getChampions()
        }
    }
}
