package com.giovannydrouet.riotstats.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.giovannydrouet.riotstats.R
import com.giovannydrouet.riotstats.databinding.FragmentChampionListBinding

//Fragment that provides the list of champions to the screen
class ChampionListFragment : Fragment() {
    private var binding: FragmentChampionListBinding? = null

    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChampionListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
