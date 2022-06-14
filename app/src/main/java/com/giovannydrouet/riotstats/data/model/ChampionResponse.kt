package com.giovannydrouet.riotstats.data.model

import kotlinx.serialization.Serializable

//Data class that receives the information from the API in a Map variable
@Serializable
data class ChampionResponse(
    val data: Map<String, ChampionRaw>
)
