package com.giovannydrouet.riotstats.data.api

import com.giovannydrouet.riotstats.data.model.ChampionResponse
import retrofit2.http.GET

//Llamarlo RiotAPI no es demasiado generico? Se supone que necesitaremos hacer mas llamadas a la API
//aparte de para los campeones

//Interface that gets the JSON from the URL
interface RiotAPI {
    @GET("data/en_US/champion.json") //Gets a JSON form this URL
    suspend fun getChampions(): ChampionResponse
}