package com.giovannydrouet.riotstats.data.mapper

import com.giovannydrouet.riotstats.data.model.ChampionImageRaw
import com.giovannydrouet.riotstats.data.model.ChampionRaw
import com.giovannydrouet.riotstats.data.model.ChampionResponse
import com.giovannydrouet.riotstats.domain.model.Champion
import org.junit.Assert
import org.junit.Test


internal class ChampionResponseMapperKtTest {
    private val championRaw = ChampionRaw(
        "Vex",
        "Enana emo",
        ChampionImageRaw(
            "Vex.png"
        )
    )

    private val data = mapOf("Vex" to championRaw)

    private val championResponse: ChampionResponse = ChampionResponse(data)

    @Test
    fun `Response should be mapped to Domain model`(){
        val actual = championResponse.toDomain()
        val expected = listOf(
            Champion("Vex",
                "Enana emo",
                "https://ddragon.leagueoflegends.com/cdn/12.11.1/img/champion/Vex.png"
        ))

        Assert.assertEquals(expected, actual)
    }

}