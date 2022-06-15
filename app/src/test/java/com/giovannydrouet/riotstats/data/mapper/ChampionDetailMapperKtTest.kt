package com.giovannydrouet.riotstats.data.mapper

import com.giovannydrouet.riotstats.data.model.ChampionDetailsResponse
import com.giovannydrouet.riotstats.data.model.ChampionResponse
import com.giovannydrouet.riotstats.data.model.ChampionStatsRaw
import com.giovannydrouet.riotstats.domain.model.ChampionDetails
import org.junit.Assert
import org.junit.Test


internal class ChampionDetailMapperKtTest {
    private val championStatsRaw: ChampionStatsRaw =
        ChampionStatsRaw(
            "Vex",
            "Enana",
            listOf("Mage", "Assassin")
        )
    private val data = mapOf("Vex" to championStatsRaw)
    private val championDetailsResponse: ChampionDetailsResponse = ChampionDetailsResponse(data)

    @Test
    fun `Response should be mapped to Domain model`() {
        val actual = championDetailsResponse.toDomain("Vex")
        val expected = ChampionDetails("Vex", "Enana", listOf("Mage", "Assassin"))

        Assert.assertEquals(expected, actual)
    }
}