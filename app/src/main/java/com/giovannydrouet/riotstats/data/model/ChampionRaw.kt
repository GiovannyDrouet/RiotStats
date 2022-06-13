package com.giovannydrouet.riotstats.data.model

data class ChampionRaw(
    val name: String,
    val image: ChampionImageRaw
)

data class ChampionImageRaw(
    val full: String
)
