package com.giovannydrouet.riotstats.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ChampionResponse(
    val data: Map<String, ChampionRaw>
)
