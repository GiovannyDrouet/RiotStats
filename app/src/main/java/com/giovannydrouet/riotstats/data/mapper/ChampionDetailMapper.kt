package com.giovannydrouet.riotstats.data.mapper

import com.giovannydrouet.riotstats.data.model.ChampionDetailsResponse
import com.giovannydrouet.riotstats.domain.model.ChampionDetails

fun ChampionDetailsResponse.toDomain(id: String): ChampionDetails {
    val championStats = requireNotNull(data[id]) {
        "Something went wrong, champion not found."
    }

    return ChampionDetails(
        championStats.title,
        championStats.blurb,
        championStats.tags
    )
}