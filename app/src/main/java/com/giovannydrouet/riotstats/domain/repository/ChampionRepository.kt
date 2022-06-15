package com.giovannydrouet.riotstats.domain.repository

import com.giovannydrouet.riotstats.domain.model.Champion
import com.giovannydrouet.riotstats.domain.model.ChampionDetails

//Interface that connects domain with data without dependencies
interface ChampionRepository {
    suspend fun getChampions() : List<Champion>
    suspend fun getChampionStats(name: String) : ChampionDetails
}