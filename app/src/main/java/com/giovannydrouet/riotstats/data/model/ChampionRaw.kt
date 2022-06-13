package com.giovannydrouet.riotstats.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ChampionRaw(
    val name: String,
    val image: ChampionImageRaw
)

@Serializable
data class ChampionImageRaw(
    val full: String
)
