package com.giovannydrouet.riotstats.data.mapper

import com.giovannydrouet.riotstats.data.model.ChampionResponse
import com.giovannydrouet.riotstats.domain.model.Champion

//Extension Function that transforms ChampionResponse(form Data) to a List of Champion(from Domain)
fun ChampionResponse.toDomain(): List<Champion> {
    return data.map {
        Champion(
            name = it.value.name,
            image = imageBaseURL + it.value.image.full
        )
    } //Maps ChampionResponse into a Champions List
}

private val imageBaseURL = "https://ddragon.leagueoflegends.com/cdn/12.11.1/img/champion/"
