package br.com.wcisang.data.remote.service

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object LodjinhaServiceFactory {

    open fun makeLodjinhaService() : LodjinhaService{
        val okHttpClient = makeOkHttpClient(makeLoggingInterceptor())
        return makeLodjinhaService(okHttpClient)
    }

    private fun makeLodjinhaService(okHttpClient: OkHttpClient) : LodjinhaService{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://alodjinha.herokuapp.com")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
        return retrofit.create(LodjinhaService::class.java)
    }

    private fun makeOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor) : OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }

    private fun makeLoggingInterceptor() : HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        HttpLoggingInterceptor.Level.BODY
        return logging
    }
}