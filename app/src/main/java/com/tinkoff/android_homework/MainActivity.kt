package com.tinkoff.android_homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.tinkoff.android_homework.data.entities.operations.Operations
import com.tinkoff.android_homework.data.services.OperationService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getOperations()
    }

    private fun getOperations() {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val contentType = "application/json".toMediaType()

        val retrofit = Retrofit
            .Builder()
            .client(client)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .baseUrl(BASE_URL)
            .build()

        val service = retrofit.create(OperationService::class.java)
        val call = service.getOperations("operations")

        call.enqueue(object : Callback<Operations> {

                override fun onResponse(call: Call<Operations>, response: Response<Operations>) {
                    if (response.isSuccessful) {
                        val operations = response.body()
                        Log.i(TAG, "Operations: $operations")
                    } else {
                        // Обработка ошибки
                    }
                }

                override fun onFailure(call: Call<Operations>, t: Throwable) {
                    // Обработка ошибки
                }
            }
        )
    }

    private companion object {
        const val BASE_URL = "https://raw.githubusercontent.com/InternetEducation/"
        const val TAG = "MainActivity"
    }
}
