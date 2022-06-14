package com.giovannydrouet.riotstats.di

import com.giovannydrouet.riotstats.data.api.RiotAPI
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

//Modules are objects(Singletons) that are called by Dagger Hilt every time it need to Inject
//dependencies. Hilt searches in every object with @Module tag for a function that returns the
//type of variable needed, even if that function needs to run another function.
@Module
@InstallIn(SingletonComponent::class)
@ExperimentalSerializationApi
object NetworkModule {

    private val json = Json {
        ignoreUnknownKeys = true
        explicitNulls = false
    }

    @Provides
    fun provideRiotService(): RiotAPI {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        val contentType = "application/json".toMediaType()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://ddragon.leagueoflegends.com/cdn/12.11.1/")
            .client(client)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()

        return retrofit.create(RiotAPI::class.java)
    }
}