package com.droker.data.repository

import com.droker.data.mapper.Mapper
import com.droker.domain.utils.RemoteErrorEmitter
import com.droker.data.repository.remote.datasource.GithubDataSource
import com.droker.domain.model.GithubEntity
import com.droker.domain.repository.GithubRepository
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(
    private val githubDataSource: GithubDataSource
) : GithubRepository {
    override suspend fun getGithub(
        remoteErrorEmitter: RemoteErrorEmitter,
        owner: String
    ): List<GithubEntity>? {
        return Mapper.mapperGithub(githubDataSource.getGithub(remoteErrorEmitter, owner))
    }
}