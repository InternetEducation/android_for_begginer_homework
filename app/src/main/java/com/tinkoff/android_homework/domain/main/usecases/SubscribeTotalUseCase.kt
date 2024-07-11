package com.tinkoff.android_homework.domain.main.usecases

import com.tinkoff.android_homework.data.network.repo.total.TotalRepository
import com.tinkoff.android_homework.domain.main.entities.Total
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

/**
 * @author d.shtaynmets
 */

interface SubscribeTotalUseCase {
    suspend fun invoke(): Flow<Total>
}

class SubscribeTotalUseCaseImpl @Inject constructor(
    private val repository: TotalRepository
): SubscribeTotalUseCase {

    override suspend fun invoke(): Flow<Total> {
        return repository.subscribeTotal()
    }
}
