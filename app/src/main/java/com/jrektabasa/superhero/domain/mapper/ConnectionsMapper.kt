package com.jrektabasa.superhero.domain.mapper

import com.jrektabasa.superhero.data.model.response.ConnectionsResponse
import com.jrektabasa.superhero.domain.model.Connections
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ConnectionsMapper @Inject constructor() {

    fun mapToDomain(response: ConnectionsResponse): Connections {
        return Connections(
            response.groupAffiliation,
            response.relatives,
        )
    }
}