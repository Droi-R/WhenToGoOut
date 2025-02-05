package com.whentogoout.di

import com.droker.domain.repository.GithubRepository
import com.droker.domain.usecase.GetUserRepoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetUserRepoUseCase(repository: GithubRepository) = GetUserRepoUseCase(repository)
}