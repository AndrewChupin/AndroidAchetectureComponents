package com.testtask.santa.core.di.modules

import com.squareup.moshi.Moshi
import com.testtask.santa.core.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import com.testtask.santa.core.network.Api
import javax.inject.Singleton


@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttp() = OkHttpClient.Builder()
        .build()

    @Singleton
    @Provides
    fun provideMoshi() = Moshi.Builder()
        .build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi) = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit) = retrofit.create(Api::class.java)

}