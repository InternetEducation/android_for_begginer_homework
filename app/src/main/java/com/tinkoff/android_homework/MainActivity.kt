package com.tinkoff.android_homework

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.tinkoff.android_homework.data.network.entities.operations.Operations
import com.tinkoff.android_homework.data.network.services.OperationService
import com.tinkoff.android_homework.data.storage.database.AppDatabase
import com.tinkoff.android_homework.data.storage.database.AppDatabase.Companion.DATABASE_NAME
import com.tinkoff.android_homework.presentation.adapter.OperationAdapter
import com.tinkoff.android_homework.presentation.model.OperationItem
import com.tinkoff.android_homework.presentation.model.OperationType
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, DATABASE_NAME
        ).build()

        getOperations()

        initStatisticCard()
        initOperationList()
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

    private fun initStatisticCard() {
        // TODO Вывести статистику
    }

    private fun initOperationList() {
        val operationRecyclerView = findViewById<RecyclerView>(R.id.operations_recycler)
        val operationAdapter = OperationAdapter()

        operationRecyclerView.layoutManager = LinearLayoutManager(this)
        operationRecyclerView.adapter = operationAdapter

        // TODO Заменить на реальные данные
        operationAdapter.data = listOf(
            OperationItem(OperationType.SPENDING, "Тест", "- 5 0000 Р"),
            OperationItem(OperationType.INCOME, "Тест", "+ 5 0000 Р"),
            OperationItem(OperationType.SPENDING, "Тест", "- 5 0000 Р"),
            OperationItem(OperationType.INCOME, "Тест", "+ 5 0000 Р"),
            OperationItem(OperationType.INCOME, "Тест", "+ 5 0000 Р"),
            OperationItem(OperationType.SPENDING, "Тест", "- 5 0000 Р")

        )
    }

    private companion object {
        const val BASE_URL = "https://raw.githubusercontent.com/InternetEducation/"
        const val TAG = "MainActivity"
    }
}
