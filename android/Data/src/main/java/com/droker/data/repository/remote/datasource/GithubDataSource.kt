package com.droker.data.repository.remote.datasource


import com.droker.data.remote.model.GithubResponse
import com.droker.domain.utils.RemoteErrorEmitter

interface GithubDataSource {
    suspend fun getGithub(remoteErrorEmitter: RemoteErrorEmitter, owner : String) : List<GithubResponse>?
}