package com.giovannydrouet.riotstats.domain.repository

import com.giovannydrouet.riotstats.domain.model.Champion

interface ChampionRepository {
    suspend fun getChampions() : List<Champion>
}