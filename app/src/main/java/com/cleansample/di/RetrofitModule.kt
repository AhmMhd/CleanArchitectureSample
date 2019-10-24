package com.gymrabbit.di.app.module

import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
object RetrofitModule {

    @JvmStatic
    @Provides
    fun provideCoroutineCallAdapter() = CoroutineCallAdapterFactory()

    @JvmStatic
    @Provides
    fun providesRetrofit(
        okHttpClient: OkHttpClient,
        callAdapterFactory: CoroutineCallAdapterFactory
    ) = Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/")
        .addCallAdapterFactory(callAdapterFactory)
        .client(okHttpClient)
        .build()


//    @JvmStatic
//    @Provides
//    fun provideGsonConverter(gson: Gson) = GsonConverterFactory.create(gson)
}