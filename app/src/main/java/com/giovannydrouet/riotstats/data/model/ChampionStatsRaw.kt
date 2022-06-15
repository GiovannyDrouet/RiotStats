package com.giovannydrouet.riotstats.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ChampionStatsRaw(
    val title: String,   //Name of the champion
    val blurb: String,
    val tags: List<String>
)