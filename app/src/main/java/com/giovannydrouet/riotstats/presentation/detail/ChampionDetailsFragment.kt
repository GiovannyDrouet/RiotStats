package com.giovannydrouet.riotstats.presentation.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.giovannydrouet.riotstats.databinding.FragmentChampionDetailsBinding
import com.giovannydrouet.riotstats.domain.model.ChampionDetails
import com.giovannydrouet.riotstats.presentation.MainViewModel


class ChampionDetailsFragment : Fragment() {
    private var binding: FragmentChampionDetailsBinding? = null
    private val mainViewModel: MainViewModel by activityViewModels()

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

        mainViewModel.championDetails.observe(viewLifecycleOwner, ::renderDetails)
        mainViewModel.getChampionDetails(args.championName)


    }

    private fun renderDetails(championStats: ChampionDetails){
        val championName: TextView? = binding?.championName
        val championTitle: TextView? = binding?.championTitle
        val championTags: TextView? = binding?.championTags
        championName?.text = championStats.title
        championTitle?.text = championStats.blurb
        championTags?.text = championStats.tags.joinToString(", ")
        Log.d("Champion Details", championStats.toString())
    }
}