package com.tinkoff.android_homework.di

import com.tinkoff.android_homework.data.network.repo.operations.OperationsRepository
import com.tinkoff.android_homework.data.network.repo.operations.OperationsRepositoryImpl
import com.tinkoff.android_homework.data.network.repo.total.TotalRepository
import com.tinkoff.android_homework.data.network.repo.total.TotalRepositoryImpl
import com.tinkoff.android_homework.domain.main.usecases.SubscribeOperationsUseCase
import com.tinkoff.android_homework.domain.main.usecases.SubscribeOperationsUseCaseImpl
import com.tinkoff.android_homework.domain.main.usecases.SubscribeTotalUseCase
import com.tinkoff.android_homework.domain.main.usecases.SubscribeTotalUseCaseImpl
import com.tinkoff.android_homework.presentation.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author d.shtaynmets
 */
@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

//    @Binds
//    abstract fun provideTotalRepository(
//        repo: TotalRepositoryImpl
//    ): TotalRepository
//
//    @Binds
//    abstract fun provideOperationsRepository(
//        repo: OperationsRepositoryImpl
//    ): OperationsRepository

    @Singleton
    @Provides
    fun provideSubscribeTotalUseCase(
        repository: TotalRepository
    ): SubscribeTotalUseCase {
        return SubscribeTotalUseCaseImpl(repository)
    }

    @Singleton
    @Provides
    fun provideSubscribeOperationUseCase(
        repository: OperationsRepository
    ): SubscribeOperationsUseCase {
        return SubscribeOperationsUseCaseImpl(repository)
    }
}
