package com.tinkoff.android_homework.di

import com.tinkoff.android_homework.data.network.mappers.operations.OperationApiToDbMapper
import com.tinkoff.android_homework.data.network.mappers.total.TotalApiToDbMapper
import com.tinkoff.android_homework.data.network.repo.operations.OperationsRepository
import com.tinkoff.android_homework.data.network.repo.operations.OperationsRepositoryImpl
import com.tinkoff.android_homework.data.network.repo.total.TotalRepository
import com.tinkoff.android_homework.data.network.repo.total.TotalRepositoryImpl
import com.tinkoff.android_homework.data.network.services.OperationsService
import com.tinkoff.android_homework.data.network.services.TotalService
import com.tinkoff.android_homework.data.storage.dao.OperationDao
import com.tinkoff.android_homework.data.storage.dao.TotalDao
import com.tinkoff.android_homework.data.storage.mappers.operations.OperationsDbToDomainMapper
import com.tinkoff.android_homework.data.storage.mappers.total.TotalDbToDomainMapper
import com.tinkoff.android_homework.domain.main.usecases.SubscribeOperationsUseCase
import com.tinkoff.android_homework.domain.main.usecases.SubscribeOperationsUseCaseImpl
import com.tinkoff.android_homework.domain.main.usecases.SubscribeTotalUseCase
import com.tinkoff.android_homework.domain.main.usecases.SubscribeTotalUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

/**
 * @author d.shtaynmets
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {


    @Binds
    abstract fun bindTotalRepository(
        impl: TotalRepositoryImpl
    ): TotalRepository

    @Binds
    abstract fun bindOperationsRepository(
        impl: OperationsRepositoryImpl
    ): OperationsRepository

//    @Provides
//    fun provideTotalRepository(
//        totalService: TotalService,
//        totalDao: TotalDao,
//        totalApiToDbMapper: TotalApiToDbMapper,
//        totalDbToDomainMapper: TotalDbToDomainMapper,
//    ): TotalRepository {
//        return TotalRepositoryImpl(
//            totalDao,
//            totalService,
//            totalApiToDbMapper,
//            totalDbToDomainMapper,
//        )
//    }

//    @Provides
//    fun provideOperationsRepository(
//        operationsService: OperationsService,
//        operationDao: OperationDao,
//        operationsApiToDbMapper: OperationApiToDbMapper,
//        operationsDbToDomainMapper: OperationsDbToDomainMapper
//    ): OperationsRepository {
//        return OperationsRepositoryImpl(
//            operationsService,
//            operationDao,
//            operationsApiToDbMapper,
//            operationsDbToDomainMapper
//        )
//    }


//    @Provides
//    fun provideSubscribeTotalUseCase(
//        repo: TotalRepository
//    ): SubscribeTotalUseCase {
//        return SubscribeTotalUseCaseImpl(repo)
//    }
//
//    @Provides
//    fun provideSubscribeOperationUseCase(
//        repo: OperationsRepository
//    ): SubscribeOperationsUseCase {
//        return SubscribeOperationsUseCaseImpl(repo)
//    }

//    @Binds
//    fun provideSubscribeOperationsUseCase(
//        useCase: SubscribeOperationsUseCaseImpl
//    ): SubscribeOperationsUseCase

}
