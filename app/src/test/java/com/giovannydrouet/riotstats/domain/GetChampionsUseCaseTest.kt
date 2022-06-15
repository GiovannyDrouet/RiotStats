package com.giovannydrouet.riotstats.domain

import com.giovannydrouet.riotstats.data.model.ChampionRaw
import com.giovannydrouet.riotstats.domain.model.Champion
import com.giovannydrouet.riotstats.domain.repository.ChampionRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
internal class GetChampionsUseCaseTest{
    @Mock
    private lateinit var championRepository: ChampionRepository
    private lateinit var getChampionsUseCase : GetChampionsUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        getChampionsUseCase = GetChampionsUseCase(championRepository)
    }

    @Test
    fun `Function should return a list of Champions`(){
        runBlocking {
            val champions = listOf(Champion("Vex", "Vex", "Vex.png"))
            `when`(championRepository.getChampions()).thenReturn(champions)
            val actual = getChampionsUseCase.getChampions()
            val expected = listOf(Champion("Vex", "Vex", "Vex.png"))

            Assert.assertEquals(expected, actual)
        }
    }
}