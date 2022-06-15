package com.giovannydrouet.riotstats.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.giovannydrouet.riotstats.databinding.FragmentChampionDetailsBinding


class ChampionDetailsFragment : Fragment() {

    private var binding: FragmentChampionDetailsBinding? = null

    val args: ChampionDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChampionDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val championName : TextView? = binding?.championName
        championName?.text = args.championName
    }
}