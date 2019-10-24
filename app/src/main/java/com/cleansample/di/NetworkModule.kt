package com.gymrabbit.di.app.module


import com.data.network.ApiInterface
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

@Module
object NetworkModule {

    @JvmStatic
    @Provides
    fun provideOkHttp() = OkHttpClient.Builder()
        .readTimeout(30, TimeUnit.SECONDS)
//        .addInterceptor(MockInterceptor())
        .writeTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .build()

    @JvmStatic
    @Provides
    fun provideApiInterface(retrofit: Retrofit) =
        retrofit.create<ApiInterface>(ApiInterface::class.java)

}