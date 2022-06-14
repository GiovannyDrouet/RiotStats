package com.giovannydrouet.riotstats.data

import com.giovannydrouet.riotstats.data.api.RiotAPI
import com.giovannydrouet.riotstats.data.mapper.toDomain
import com.giovannydrouet.riotstats.domain.model.Champion
import com.giovannydrouet.riotstats.domain.repository.ChampionRepository
import javax.inject.Inject

//Class that instances Hilt in order to make a breach between Data and Domain without dependencies
class ChampionRepositoryImpl @Inject constructor(
    private val service: RiotAPI
) : ChampionRepository {

    override suspend fun getChampions(): List<Champion> {
        return service.getChampions().toDomain()
    }
}