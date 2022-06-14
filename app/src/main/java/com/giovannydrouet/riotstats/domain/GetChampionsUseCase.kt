package com.giovannydrouet.riotstats.domain

import com.giovannydrouet.riotstats.domain.model.Champion
import com.giovannydrouet.riotstats.domain.repository.ChampionRepository
import javax.inject.Inject

//Class with the function that receives the list sent by data/hilt and stores it in domain to
//share it with presentation
class GetChampionsUseCase @Inject constructor(private val championRepository: ChampionRepository) {

    suspend fun getChampions(): List<Champion> {
        return championRepository.getChampions()
    }
}