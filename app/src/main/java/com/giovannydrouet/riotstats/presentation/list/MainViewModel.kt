package com.giovannydrouet.riotstats.presentation.list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.giovannydrouet.riotstats.domain.GetChampionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//ViewModel that provides the list of champions to 'ChampionListFragment'
@HiltViewModel
class MainViewModel @Inject constructor(
    private val getChampionsUseCase: GetChampionsUseCase
) : ViewModel() {

    fun getChampionList() {
        viewModelScope.launch {     //EVERY FUNCTION EXECUTED IN LAUNCH MUST BE 'SUSPEND FUN'
            val champions = getChampionsUseCase.getChampions()
            Log.d("Champions", champions.toString())
        }
    }
}
