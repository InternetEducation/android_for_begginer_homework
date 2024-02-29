package com.tinkoff.android_homework.data.network.services

import com.tinkoff.android_homework.data.network.entities.operations.Operations
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author d.shtaynmets
 */
interface OperationService {

    @GET("android_for_begginers_back_end/main/{user}.json")
    fun getOperations(
        @Path("user") user: String,
    ): Call<Operations>
}
