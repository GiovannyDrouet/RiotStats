package com.giovannydrouet.riotstats.presentation.list

import androidx.lifecycle.ViewModel
import com.giovannydrouet.riotstats.domain.model.Champion
import com.giovannydrouet.riotstats.domain.GetChampions
import javax.inject.Inject

class ChampionListViewModel @Inject constructor(
    private val getChampions: GetChampions
) : ViewModel() {

    fun getChampionList(): List<Champion> {
        return getChampions.getChampions()
    }
}