package com.giovannydrouet.riotstats.data.model

import kotlinx.serialization.Serializable

//Data class that receives the information from the API and stores it as a data variable
@Serializable
data class ChampionResponse(
    val data: Map<String, ChampionRaw>
)
