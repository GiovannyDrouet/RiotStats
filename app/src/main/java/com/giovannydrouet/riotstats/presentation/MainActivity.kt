package com.giovannydrouet.riotstats.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import com.giovannydrouet.riotstats.R
import com.giovannydrouet.riotstats.presentation.list.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

//I do not know, MainActivity is what it is, the Main activity :v
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel.getChampionList() //Starts ViewModel's function
    }
}