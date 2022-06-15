package com.giovannydrouet.riotstats.data.model

import kotlinx.serialization.Serializable

//Data classes that store the name and the image of the champions from the API for future uses.
@Serializable
data class ChampionRaw(
    val name: String,   //Name of the champion
    val image: ChampionImageRaw
)

@Serializable
data class ChampionImageRaw(
    val full: String    //Image of the champion
)

@Serializable
data class ChampionStats(
    val title: String,   //Name of the champion
    val blurb: String,
    val tags: List<String>
)
