package com.giovannydrouet.riotstats.presentation.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.giovannydrouet.riotstats.R
import com.giovannydrouet.riotstats.databinding.FragmentChampionListBinding
import com.giovannydrouet.riotstats.domain.model.Champion
import com.giovannydrouet.riotstats.presentation.MainViewModel
import com.giovannydrouet.riotstats.presentation.detail.ChampionDetailsFragmentArgs
import com.giovannydrouet.riotstats.presentation.recylcerview.ChampionListAdapter

//Fragment that provides the list of champions to the screen
class ChampionListFragment : Fragment() {
    private var binding: FragmentChampionListBinding? = null
    private val mainViewModel: MainViewModel by activityViewModels()

    private val championListAdapter = ChampionListAdapter(::onItemClicked)

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel.champions.observe(viewLifecycleOwner, ::renderList)
        mainViewModel.getChampionList()

        binding?.championListRecyclerView?.layoutManager = GridLayoutManager(requireContext(),3)
        binding?.championListRecyclerView?.adapter = championListAdapter
    }

    private fun renderList(championList : List<Champion>){
        championListAdapter.setDataList(championList)
        championListAdapter.notifyDataSetChanged()
    }

    private fun onItemClicked(name : String) {
        findNavController().navigate(ChampionListFragmentDirections.listToDetails(name))
    }
}
