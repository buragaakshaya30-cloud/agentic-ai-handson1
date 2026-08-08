package  com.project.handson_1.network

import okhttp3.OkHttpClient
import okhttp3.Request
import com.project.handson_1.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private val okHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor { chain ->
                val originalRequest = chain.request()
                val originalUrl = originalRequest.url

                val url = originalUrl.newBuilder()
                    .addQueryParameter("key", Constants.API_KEY)
                    .build()

                val request = originalRequest.newBuilder()
                    .url(url)
                    .addHeader("Authorization", "Bearer ${Constants.API_KEY}")
                    .build()

                chain.proceed(request)
            }
            .build()
    }

    private val retrofit by lazy {

        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

}