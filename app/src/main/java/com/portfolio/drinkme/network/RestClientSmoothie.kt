package com.portfolio.drinkme.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RestClientSmoothie() {
    private val BASE_URL_PROD ="https://myprojectapp-fa50e-default-rtdb.firebaseio.com/" //PROD
    private val BASE_URL_DEV = "https://api.punkapi.com/v2/" //DEV
    private val BASE_URL_STG = "https://api.punkapi.com/v2/" //STG

    private val CONNECT_TIMEOUT = 30 * 2
    private val WRITE_TIMEOUT = 30 * 2
    private val READ_TIMEOUT = 30 * 2
    private var api: APISmoothie? = null

    init {
        setup()
    }

    fun get(): APISmoothie? {
        return api
    }
    private fun setup() {
        val loggingInterceptor =
            HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(CONNECT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL_PROD) //<-- URL ENVIRONMENT
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        api = retrofit.create<APISmoothie>(APISmoothie::class.java)
    }

}