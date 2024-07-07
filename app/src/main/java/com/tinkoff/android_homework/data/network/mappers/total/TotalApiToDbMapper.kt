package com.tinkoff.android_homework.data.network.mappers.total

import com.tinkoff.android_homework.data.network.entities.total.TotalApi
import com.tinkoff.android_homework.data.storage.entities.TotalDb

/**
 * @author d.shtaynmets
 */
internal class TotalApiToDbMapper : (TotalApi) -> TotalDb {
    override fun invoke(totalApi: TotalApi): TotalDb {
        return TotalDb(outcome = totalApi.outcome, income = totalApi.income)
    }
}
