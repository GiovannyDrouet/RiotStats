package com.giovannydrouet.riotstats.data.mapper

import com.giovannydrouet.riotstats.data.model.ChampionResponse
import com.giovannydrouet.riotstats.domain.model.Champion

//Extension Function
fun ChampionResponse.toDomain(): List<Champion> {
    return data.map { Champion(it.value.name) }
}
