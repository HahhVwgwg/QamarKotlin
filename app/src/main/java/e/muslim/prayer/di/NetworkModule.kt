package e.muslim.prayer.di

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import e.muslim.prayer.data.repository.NetworkDataSource
import e.muslim.prayer.utils.CREDENTIALS_HEADER
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val networkModule = module {
    single { getOkHttpClient() }
    single { getRetrofit(get()) }

    single {
        val retrofit: Retrofit = get()
        retrofit.create(NetworkDataSource::class.java) as NetworkDataSource
    }
}

fun getRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl("BuildConfig.BASE_URL")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(okHttpClient)
        .build()
}


fun getOkHttpClient(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .addInterceptor {
            val requestBuilder = it.request().newBuilder()
                .addHeader(CREDENTIALS_HEADER, "Bearer")
            it.proceed(requestBuilder.build())
        }
        .connectTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()
}