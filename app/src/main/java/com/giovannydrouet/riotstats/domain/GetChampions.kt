package com.giovannydrouet.riotstats.domain

import com.giovannydrouet.riotstats.domain.model.Champion
import com.giovannydrouet.riotstats.domain.repository.ChampionRepository
import javax.inject.Inject

class GetChampions @Inject constructor(private val championRepository: ChampionRepository) {

    suspend fun getChampions(): List<Champion> {
        return championRepository.getChampions()
    }
}