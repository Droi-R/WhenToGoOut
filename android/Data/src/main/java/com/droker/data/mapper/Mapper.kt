package com.droker.data.mapper

import com.droker.data.remote.model.GithubResponse
import com.droker.domain.model.GithubEntity


object Mapper {
    fun mapperGithub(response: List<GithubResponse>?) : List<GithubEntity>? {
        return if (response != null){
            response.toDomain()
        } else null
    }

    fun List<GithubResponse>.toDomain() : List<GithubEntity> {
        return this.map {
            GithubEntity(
                it.name,
                it.id,
                it.date,
                it.url
            )
        }
    }
}