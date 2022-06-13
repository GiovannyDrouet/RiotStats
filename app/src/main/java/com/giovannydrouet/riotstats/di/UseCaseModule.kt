package com.giovannydrouet.riotstats.di

import com.giovannydrouet.riotstats.data.ChampionRepositoryImpl
import com.giovannydrouet.riotstats.data.api.RiotAPI
import com.giovannydrouet.riotstats.domain.repository.ChampionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideRiotRepository(riotService: RiotAPI): ChampionRepository {
        return ChampionRepositoryImpl(riotService)
    }
}