package com.giovannydrouet.riotstats.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.giovannydrouet.riotstats.domain.GetChampionsUseCase
import com.giovannydrouet.riotstats.domain.model.Champion
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//ViewModel that provides the list of champions to 'ChampionListFragment'
@HiltViewModel
class MainViewModel @Inject constructor(
    private val getChampionsUseCase: GetChampionsUseCase
) : ViewModel() {
    private val championLiveData = MutableLiveData<List<Champion>>()
    val champions : LiveData<List<Champion>> = championLiveData
    fun getChampionList() {
        viewModelScope.launch {     //EVERY FUNCTION EXECUTED IN LAUNCH MUST BE 'SUSPEND FUN'
            championLiveData.postValue(getChampionsUseCase.getChampions())
        }
    }
}
