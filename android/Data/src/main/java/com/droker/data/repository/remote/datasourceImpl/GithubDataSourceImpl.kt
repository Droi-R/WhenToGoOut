package com.droker.data.repository.remote.datasourceImpl

import com.droker.data.remote.api.GithubApi
import com.droker.data.remote.model.GithubResponse
import com.droker.data.repository.remote.datasource.GithubDataSource
import com.droker.domain.utils.RemoteErrorEmitter
import com.droker.data.utils.base.BaseRepository
import javax.inject.Inject

class GithubDataSourceImpl @Inject constructor(
    private val githubApi: GithubApi,
) : BaseRepository(), GithubDataSource {
    override suspend fun getGithub(remoteErrorEmitter: RemoteErrorEmitter, owner: String): List<GithubResponse>? {
        return safeApiCall(remoteErrorEmitter) { githubApi.getRepos(owner).body() }
    }
}
