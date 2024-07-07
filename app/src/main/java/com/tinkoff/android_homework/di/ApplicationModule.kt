package com.tinkoff.android_homework.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.tinkoff.android_homework.MainActivity
import com.tinkoff.android_homework.data.network.services.TotalService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

/**
 * @author d.shtaynmets
 */
@Module
@InstallIn(ActivityComponent::class)
object ApplicationModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val contentType = "application/json".toMediaType()
        return Retrofit
            .Builder()
            .client(client)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .baseUrl(MainActivity.BASE_URL)
            .build()
    }

    @Provides
    fun provideTotalService(retrofit: Retrofit): TotalService {
        return retrofit.create(TotalService::class.java)
    }
}
