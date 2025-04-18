package com.droker.domain.repository

import com.droker.domain.model.GithubEntity
import com.droker.domain.utils.RemoteErrorEmitter

interface GithubRepository {
    suspend fun getGithub(remoteErrorEmitter: RemoteErrorEmitter, owner : String) : List<GithubEntity>?
}