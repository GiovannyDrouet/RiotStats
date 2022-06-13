package com.giovannydrouet.riotstats.domain

import com.giovannydrouet.riotstats.domain.model.Champion
import com.giovannydrouet.riotstats.domain.repository.ChampionRepository

class GetChampions(private val championRepository: ChampionRepository) {

    fun getChampions(): List<Champion> {
        return championRepository.getChampions()
    }
}