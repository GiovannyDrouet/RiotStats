package com.giovannydrouet.riotstats.data.mapper

import com.giovannydrouet.riotstats.data.model.ChampionDetailsResponse
import com.giovannydrouet.riotstats.domain.model.ChampionDetails

fun ChampionDetailsResponse.toDomain(id: String): ChampionDetails {
    val championStat = requireNotNull(data[id]) {
        "Something went wrong, champion not found."
    }

    return ChampionDetails(
        championStat.title,
        championStat.blurb,
        championStat.tags
    )
}