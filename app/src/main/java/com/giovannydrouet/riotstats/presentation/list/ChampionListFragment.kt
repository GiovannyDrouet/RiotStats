package com.giovannydrouet.riotstats.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.giovannydrouet.riotstats.R
import com.giovannydrouet.riotstats.databinding.FragmentChampionListBinding

class ChampionListFragment : Fragment() {
    private var binding: FragmentChampionListBinding? = null

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
