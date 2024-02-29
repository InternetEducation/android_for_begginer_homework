package com.tinkoff.android_homework.data.storage.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tinkoff.android_homework.data.storage.dao.OperationDao
import com.tinkoff.android_homework.data.storage.entities.OperationDb

/**
 * @author d.shtaynmets
 */
@Database(entities = [OperationDb::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun operationDao(): OperationDao

    companion object {
        const val DATABASE_NAME = "operations.db"
    }
}
