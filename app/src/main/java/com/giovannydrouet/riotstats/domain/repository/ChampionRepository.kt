package com.giovannydrouet.riotstats.domain.repository

import com.giovannydrouet.riotstats.domain.model.Champion

//Interface that makes presentation able to get a list with every Champion found in Data
interface ChampionRepository {
    suspend fun getChampions() : List<Champion>
}