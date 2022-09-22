package com.justin.taipeizoobrowser.network

import com.justin.taipeizoobrowser.data.BuildingsResult
import com.justin.taipeizoobrowser.data.PlantsResult
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val HOST_NAME = "data.taipei/api"
private const val API_VERSION = "v1"
private const val BASE_URL = "https://$HOST_NAME/$API_VERSION/dataset/"
private const val SCOPE = "resourceAquire"
private const val BUILDINGS = "5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a"
private const val PLANTS = "f18de02f-b6c9-47c0-8cda-50efad621c14"

private val moshi = Moshi.Builder()
    .addLast(KotlinJsonAdapterFactory())
    .build()

private val client = OkHttpClient.Builder()
    .addInterceptor(
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    )
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .client(client)
    .build()

interface WebService {

    @GET(BUILDINGS)
    suspend fun getBuildings(
        @Query("scope") scope: String = SCOPE
    ): BuildingsResult

    @GET(PLANTS)
    suspend fun getPlants(
        @Query("scope") scope: String = SCOPE
    ): PlantsResult
}

object WebApi {
    val retrofitService: WebService by lazy { retrofit.create(WebService::class.java) }
}
