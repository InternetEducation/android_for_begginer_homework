package com.tinkoff.android_homework.data.network.repo.total

import com.tinkoff.android_homework.data.network.mappers.total.TotalApiToDbMapper
import com.tinkoff.android_homework.data.network.services.TotalService
import com.tinkoff.android_homework.data.storage.dao.TotalDao
import com.tinkoff.android_homework.data.storage.mappers.total.TotalDbToDomainMapper
import com.tinkoff.android_homework.domain.main.entities.Total

/**
 * @author d.shtaynmets
 */
interface TotalRepository {

    suspend fun subscribeTotal(): Total

}

internal class TotalRepositoryImpl(
    private val totalService: TotalService,
    private val totalDao: TotalDao,
    private val totalApiToDbMapper: TotalApiToDbMapper,
    private val totalDbToDomainMapper: TotalDbToDomainMapper
) : TotalRepository {
    override suspend fun subscribeTotal(): Total {
        val totalApi = totalService.getTotal()
        totalDao.insert(totalApiToDbMapper.invoke(totalApi))

        return totalDbToDomainMapper.invoke(totalDao.getAll())
    }
}
