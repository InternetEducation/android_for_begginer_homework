package com.tinkoff.android_homework.domain.main.usecases

import com.tinkoff.android_homework.data.network.repo.total.TotalRepository
import com.tinkoff.android_homework.domain.main.entities.Total
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

/**
 * @author d.shtaynmets
 */
interface SubscribeTotalUseCase {
    suspend fun invoke(): Total
}

internal class SubscribeTotalUseCaseImpl(
    private val repository: TotalRepository
): SubscribeTotalUseCase {

    override suspend fun invoke(): Total {
        return repository.subscribeTotal()
    }
}
