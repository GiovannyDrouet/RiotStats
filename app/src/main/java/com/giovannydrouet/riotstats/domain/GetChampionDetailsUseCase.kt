package com.giovannydrouet.riotstats.domain

import com.giovannydrouet.riotstats.domain.model.ChampionDetails
import com.giovannydrouet.riotstats.domain.repository.ChampionRepository
import javax.inject.Inject

class GetChampionDetailsUseCase @Inject constructor(private val championRepository: ChampionRepository) {
    suspend fun getChampionsDetails(id: String): ChampionDetails {
        return championRepository.getChampionStats(id)
    }
}