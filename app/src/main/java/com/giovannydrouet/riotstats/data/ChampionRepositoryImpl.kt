package com.giovannydrouet.riotstats.data

import com.giovannydrouet.riotstats.data.api.RiotAPI
import com.giovannydrouet.riotstats.domain.model.Champion
import com.giovannydrouet.riotstats.domain.repository.ChampionRepository
import retrofit2.Retrofit

class ChampionRepositoryImpl : ChampionRepository {
    var retrofit = Retrofit.Builder()
        .baseUrl("http://ddragon.leagueoflegends.com/cdn/12.11.1/")
        .build()

    val service: RiotAPI = retrofit.create(RiotAPI::class.java)

    override fun getChampions(): List<Champion> {
        return service.getChampions().data.map { Champion(it.value.name) }
    }
}