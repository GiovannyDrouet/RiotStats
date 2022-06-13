package com.giovannydrouet.riotstats.data.api

import com.giovannydrouet.riotstats.data.model.ChampionResponse
import retrofit2.http.GET

interface RiotAPI {
    @GET("data/en_US/champion.json")
    fun getChampions(): ChampionResponse
}