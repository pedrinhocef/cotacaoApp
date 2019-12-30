package com.pedrosoares.cotacaoapp.data.remote.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Requester {
    private const val URL = "https://economia.awesomeapi.com.br/"
    private var retrofit: Retrofit? = null
    @JvmStatic
    val service: Retrofit
        get() {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
            client.addInterceptor(interceptor)
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl(URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .client(client.build())
                        .build()
            }
            return retrofit!!
        }
}


