package com.whentogoout.di

import com.droker.data.remote.api.GithubApi
import com.droker.data.repository.remote.datasource.GithubDataSource
import com.droker.data.repository.remote.datasourceImpl.GithubDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceImplModule {

    @Provides
    @Singleton
    fun provideMainDataSource(
        githubApi: GithubApi
    ) : GithubDataSource {
        return GithubDataSourceImpl(
            githubApi
        )
    }
}