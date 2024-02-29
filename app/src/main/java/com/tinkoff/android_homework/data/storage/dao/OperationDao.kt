package com.tinkoff.android_homework.data.storage.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.tinkoff.android_homework.data.storage.entities.OperationDb

/**
 * @author d.shtaynmets
 */
@Dao
interface OperationDao {
    @Query("SELECT * FROM ${OperationDb.OPERATION_TABLE_NAME}")
    suspend fun getAll(): List<OperationDb>

    @Query("SELECT * FROM ${OperationDb.OPERATION_TABLE_NAME} WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<OperationDb>

    @Insert
    suspend fun insertAll(vararg operations: OperationDb)

    @Delete
    fun delete(operation: OperationDb)
}
