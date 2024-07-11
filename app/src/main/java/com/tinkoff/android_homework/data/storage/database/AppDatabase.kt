package com.tinkoff.android_homework.data.storage.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tinkoff.android_homework.data.storage.dao.OperationDao
import com.tinkoff.android_homework.data.storage.dao.TotalDao
import com.tinkoff.android_homework.data.storage.entities.OperationDb
import com.tinkoff.android_homework.data.storage.entities.TotalDb

/**
 * @author d.shtaynmets
 */
@Database(entities = [OperationDb::class, TotalDb::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun operationDao(): OperationDao
    abstract fun totalDao(): TotalDao

    companion object {
        const val DATABASE_NAME = "operations.db"
    }
}
