package com.giovannydrouet.riotstats.domain.repository

import com.giovannydrouet.riotstats.domain.model.Champion

//Interface that connects domain with data without dependencies
interface ChampionRepository {
    suspend fun getChampions() : List<Champion>
}