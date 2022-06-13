package com.giovannydrouet.riotstats.data

import com.giovannydrouet.riotstats.data.api.RiotAPI
import com.giovannydrouet.riotstats.data.mapper.toDomain
import com.giovannydrouet.riotstats.domain.model.Champion
import com.giovannydrouet.riotstats.domain.repository.ChampionRepository
import javax.inject.Inject

class ChampionRepositoryImpl @Inject constructor(
    private val service: RiotAPI
) : ChampionRepository {

    override fun getChampions(): List<Champion> {
        return service.getChampions().toDomain()
    }
}