package com.giovannydrouet.riotstats.domain

import com.giovannydrouet.riotstats.domain.model.Champion
import com.giovannydrouet.riotstats.domain.model.ChampionDetails
import com.giovannydrouet.riotstats.domain.repository.ChampionRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

internal class GetChampionDetailsUseCaseTest() {
    private val championRepository: FakeChampionRepository = FakeChampionRepository()
    private val getChampionsDetailsUseCase: GetChampionDetailsUseCase =
        GetChampionDetailsUseCase(championRepository)

    @Test
    fun `Function should return a list of Champions`() {
        runBlocking {
            val actual = getChampionsDetailsUseCase.getChampionsDetails("Vex")
            val expected = ChampionDetails("Enana", "Enana2", listOf("Mage", "Assassin"))

            Assert.assertEquals(expected, actual)
        }
    }
}

private class FakeChampionRepository() : ChampionRepository {

    override suspend fun getChampions(): List<Champion> {
        return listOf()
    }

    override suspend fun getChampionStats(id: String): ChampionDetails {
        return ChampionDetails("Enana", "Enana2", listOf("Mage", "Assassin"))
    }

}