package com.tinkoff.android_homework.data.storage.mappers.total

import com.tinkoff.android_homework.data.storage.entities.TotalDb
import com.tinkoff.android_homework.domain.main.entities.Total

/**
 * @author d.shtaynmets
 */
internal class TotalDbToDomainMapper : (TotalDb) -> Total {

    override fun invoke(totalDb: TotalDb): Total {
        return Total(outcome = totalDb.outcome, income = totalDb.income)
    }

}
