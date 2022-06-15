package com.giovannydrouet.riotstats.data.api

import com.giovannydrouet.riotstats.data.model.ChampionDetailsResponse
import com.giovannydrouet.riotstats.data.model.ChampionResponse
import retrofit2.http.GET
import retrofit2.http.Path

//Interface that gets the JSON from the URL
interface RiotAPI {
    @GET("data/en_US/champion.json") //Gets a JSON form this URL
    suspend fun getChampions(): ChampionResponse

    @GET("data/en_US/champion/{championId}.json")
    suspend fun getChampionDetails(@Path("championId") championId : String): ChampionDetailsResponse
}