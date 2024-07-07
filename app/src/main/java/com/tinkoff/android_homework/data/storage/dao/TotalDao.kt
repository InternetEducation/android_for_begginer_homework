package com.tinkoff.android_homework.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tinkoff.android_homework.data.storage.entities.TotalDb

/**
 * @author d.shtaynmets
 */
@Dao
interface TotalDao {

    @Query("SELECT * FROM ${TotalDb.TOTAL_TABLE_NAME}")
    suspend fun getAll(): TotalDb

    @Insert
    suspend fun insert(totalDb: TotalDb)
}
