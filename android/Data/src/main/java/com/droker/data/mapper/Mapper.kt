package com.droker.data.mapper

import com.droker.data.remote.model.GithubResponse

object Mapper {
    fun mapperGithub(response: List<GithubResponse>?) : List<GithubResponse>? {
        return if (response != null){
            response.toDomain()
        } else null
    }

    fun List<GithubResponse>.toDomain() : List<GithubResponse> {
        return this.map {
            GithubResponse(
                it.name,
                it.id,
                it.date,
                it.url
            )
        }
    }
}