package com.tinkoff.android_homework.data.storage.entities

import androidx.room.Entity
import com.tinkoff.android_homework.data.storage.entities.TotalDb.Companion.TOTAL_TABLE_NAME
import com.tinkoff.android_homework.domain.main.entities.Total

/**
 * @author d.shtaynmets
 */
@Entity(tableName = TOTAL_TABLE_NAME)
data class TotalDb(
    val outcome: Int,
    val income: Int,
) {

    companion object {
        const val TOTAL_TABLE_NAME = "total_table"
    }
}
