package com.whentogoout.di

import com.droker.data.repository.GithubRepositoryImpl
import com.droker.data.repository.remote.datasourceImpl.GithubDataSourceImpl
import com.droker.domain.repository.GithubRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMainRepository(
        githubDataSourceImpl: GithubDataSourceImpl
    ): GithubRepository {
        return GithubRepositoryImpl(
            githubDataSourceImpl
        )
    }
}