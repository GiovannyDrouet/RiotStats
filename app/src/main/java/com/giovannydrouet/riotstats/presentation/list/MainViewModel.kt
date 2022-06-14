package com.giovannydrouet.riotstats.presentation.list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.giovannydrouet.riotstats.domain.GetChampions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//ViewModel that provides the list of champions to 'ChampionListFragment'
@HiltViewModel
class MainViewModel @Inject constructor(
    private val getChampions: GetChampions
) : ViewModel() {

    fun getChampionList() {
        viewModelScope.launch {     //EVERY FUNCTION EXECUTED IN LAUNCH MUST BE 'SUSPEND FUN'
            val champions = getChampions.getChampions()
            Log.d("Champions", champions.toString())
        }
    }
}
