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

@Module
@InstallIn(SingletonComponent::class)
@ExperimentalSerializationApi
object NetworkModule {

    @Provides
    fun provideRiotService(): RiotAPI {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        val contentType = "application/json".toMediaType()
        val retrofit = Retrofit.Builder()
            .baseUrl("http://ddragon.leagueoflegends.com/cdn/12.11.1/")
            .client(client)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()

        return retrofit.create(RiotAPI::class.java)
    }
}