package com.giovannydrouet.riotstats.di

import com.giovannydrouet.riotstats.data.ChampionRepositoryImpl
import com.giovannydrouet.riotstats.data.api.RiotAPI
import com.giovannydrouet.riotstats.domain.repository.ChampionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

//Modules are objects(Singletons) that are called by Dagger Hilt every time it need to Inject
//dependencies. Hilt searches in every object with @Module tag for a function that returns the
//type of variable needed, even if that function needs to run another function.
@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideRiotRepository(riotService: RiotAPI): ChampionRepository {
        return ChampionRepositoryImpl(riotService)
    }
}