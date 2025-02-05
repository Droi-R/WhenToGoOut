package com.droker.domain.usecase

import com.droker.domain.repository.GithubRepository
import com.droker.domain.utils.RemoteErrorEmitter
import javax.inject.Inject

class GetUserRepoUseCase @Inject constructor(
    private val githubRepository: GithubRepository
) {
    suspend fun execute(remoteErrorEmitter: RemoteErrorEmitter, owner : String) = githubRepository.getGithub(remoteErrorEmitter, owner)
}